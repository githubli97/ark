package com.ark.identify.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
public class JsonAuthenticationFilter extends OncePerRequestFilter {
    private ObjectMapper objectMapper;
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getContentType() != null && request.getContentType().startsWith(MediaType.APPLICATION_JSON_VALUE)) {
            try (InputStream inputStream = request.getInputStream()) {
                Map<String, String> param = objectMapper.readValue(inputStream, Map.class);
                String username = param.get("username");
                String password = param.get("password");

                log.info("username: {}, password: {}", username, password);

            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
