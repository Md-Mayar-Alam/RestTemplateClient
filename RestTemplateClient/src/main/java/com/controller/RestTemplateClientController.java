package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.RestTemplateClientService;

@Controller
public class RestTemplateClientController {

	@Autowired
	RestTemplateClientService restTemplateClientService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/getRestMsg")
	public String getResponseFromRestCall() {
		ResponseEntity<String> response= restTemplateClientService.executeRESTCall();
		
		String responseString= response.toString();
		String responseBody= response.getBody();
		System.out.println("ResponseString "+ responseString);
		System.out.println("ResponseBody "+responseBody);
		
		return responseBody;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/test")
	public String testMsgClient() {
		return "Test msg from RestTemplateClientController";
	}
}
