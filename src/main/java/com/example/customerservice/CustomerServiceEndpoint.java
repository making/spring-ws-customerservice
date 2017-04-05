package com.example.customerservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerServiceEndpoint {
	private static final Logger log = LoggerFactory
			.getLogger(CustomerServiceEndpoint.class);

	private final CustomerService customerService;

	public CustomerServiceEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PayloadRoot(namespace = "http://customerservice.example.com/", localPart = "getCustomersByName")
	@ResponsePayload
	public GetCustomersByNameResponse getCustomersByName(
			@RequestPayload GetCustomersByName request) {
		String name = request.getName();
		log.info("Received name = {}", name);

		List<Customer> customers = customerService.findByName(name);

		GetCustomersByNameResponse response = new GetCustomersByNameResponse();
		response.getReturn().addAll(customers);
		return response;
	}

}