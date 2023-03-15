package com.ark.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class OAuth2ResourceServerController {

	@GetMapping("/auth-message")
	public String message() {
		log.info("secret message");
		return "secret message";
	}

	@GetMapping("/message")
	public String createMessage() {
		return "no auth message";
	}

	@GetMapping("/auth-info")
	public String authinfo(Authentication authentication) throws Exception {
		return String.format("user name: %s", new ObjectMapper().writeValueAsString(authentication.getName()));
	}

}
