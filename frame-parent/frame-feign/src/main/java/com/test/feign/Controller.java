package com.test.feign;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class Controller {

	@Autowired
	private FiegnTest fiegnTest;
	
	@Value("${frame.address}")
	private String address;
	
	@Autowired
	private Auth auth;
	
	@RequestMapping("/test")
	public String test(String value) {
		Map m =fiegnTest.test(value);
		return m.toString();
	}
	
	@RequestMapping("/auth")
	public String testConfig(){
		return auth.toString();
	}
	
	@RequestMapping("/address")
	public String testConfig2(){
		return address;
	}
}
