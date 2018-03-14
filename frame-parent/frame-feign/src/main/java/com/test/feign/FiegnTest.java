package com.test.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("frame-service")
public interface FiegnTest {

	@PostMapping(value = "/test/feign", consumes = MediaType.APPLICATION_JSON_VALUE)
	Map test( String  param);
}
