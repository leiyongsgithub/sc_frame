package com.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {
	
	@RequestMapping("/t")
	public String test(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return simpleDateFormat.format(new Date());
	}
	@PostMapping("/feign")
	public Map fiegntest(@RequestBody String value){
		Map map = new ConcurrentHashMap();
		map.put("res", value);
		return map;
	}
}
