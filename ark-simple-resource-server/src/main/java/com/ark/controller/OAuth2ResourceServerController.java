package com.ark.controller;

import com.nimbusds.jose.shaded.json.JSONValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String createMessage(@RequestBody String message) {
		return String.format("Message was created. Content: %s", message);
	}

	@GetMapping("/auth-info")
	public String authinfo(Authentication authentication) {
		return String.format("user name: %s", JSONValue.toJSONString(authentication.getName()));
	}

}
