package com.myjd.at.cloudconfig.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudConfigClientApplication {
	
	@Value("${my.current.org}")
	private String currentOrg;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	
	@GetMapping(
		      value = "/whoami/{username}",  
		      produces = MediaType.TEXT_PLAIN_VALUE)
		    public String whoami(@PathVariable("username") String username) {
		        return String.format("Hello! You're %s and you work in a(n) %s...\n", username, currentOrg);
		    }}
