package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FrameService {
	 public static void main(String[] args) {
	        SpringApplication.run(FrameService.class, args);
	    }
}
