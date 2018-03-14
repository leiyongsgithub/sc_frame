package com.test.feign;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("frame.auth")
public class Auth {
	
	private Integer id;
	private String name;
	

	public Auth() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Auth [id=" + id + ", name=" + name + "]";
	}
	
	
}
