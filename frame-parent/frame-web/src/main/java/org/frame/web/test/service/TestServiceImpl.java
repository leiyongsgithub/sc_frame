package org.frame.web.test.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	public String test() {
		return "web service answer";
	}
	
	
}
