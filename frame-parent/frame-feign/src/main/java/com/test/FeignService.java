package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import com.test.feign.Auth;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({ Auth.class })
@Configuration
public class FeignService {
	
	
	public static void main(String[] args) {
		SpringApplication.run(FeignService.class, args);
	}
}
