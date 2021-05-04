package de.tekup.loan.invoke.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.invoke.service.RestClient;
import de.tekup.loan.invoke.service.RestClientFeign;
import de.tekup.loan.invoke.ui.types.CustomerRequest;
import de.tekup.loan.invoke.ui.types.WsResponse;

@Controller
public class CheckController {
	@Autowired
	private RestClient client;
	//alternative way
	@Autowired
	private RestClientFeign feignClient;
	
	@GetMapping("/check/customer")
	public String checkForm(Model model) {
		CustomerRequest request = new CustomerRequest();
		request.setCibilScore(500);
		model.addAttribute("request", request);
		return "request";
	}
	
	@PostMapping("/check/customer")
	public String LaonEligebel(@ModelAttribute("request") CustomerRequest request,
			Model model) {
		//call of service
		//WsResponse response = client.getLoanStatus(request);
		// other way
		WsResponse response = feignClient.consumeByFeign(request);
		model.addAttribute("response",response);
		return "response";
	}

}
