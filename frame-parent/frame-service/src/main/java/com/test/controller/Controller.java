package com.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
