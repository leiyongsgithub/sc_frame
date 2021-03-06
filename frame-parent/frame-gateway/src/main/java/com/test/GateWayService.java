package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@EnableZuulServer
@EnableZuulProxy
@SpringBootApplication
public class GateWayService {
	public static void main(String[] args) {
		SpringApplication.run(GateWayService.class, args);
	}
}
