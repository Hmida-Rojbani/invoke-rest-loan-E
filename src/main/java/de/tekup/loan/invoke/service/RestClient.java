package de.tekup.loan.invoke.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.tekup.loan.invoke.ui.types.CustomerRequest;
import de.tekup.loan.invoke.ui.types.WsResponse;

@Service
public class RestClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	private static final String URL = "http://localhost:8080/api/get-status";
	
	public WsResponse getLoanStatus(CustomerRequest request) {
		// call for the service
		WsResponse response = restTemplate.postForObject(URL, request, WsResponse.class);
		
		return response;
	}

}
