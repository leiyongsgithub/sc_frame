package com.test.feign;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class Controller {

	@Autowired
	private FiegnTest fiegnTest;
	
	@RequestMapping("test")
	public String test(String value) {
		Map m =fiegnTest.test(value);
		return m.toString();
	}
}
