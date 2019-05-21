package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateClientService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<String> executeRESTCall() {
		String endPointUri= "http://localhost:9099/restServerHello";
		return restTemplate.getForEntity(endPointUri, String.class);
	}
}
