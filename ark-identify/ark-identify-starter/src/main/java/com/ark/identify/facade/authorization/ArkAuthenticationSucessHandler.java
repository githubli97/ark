package com.ark.identify.facade.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArkAuthenticationSucessHandler implements AuthenticationSuccessHandler {

  private ObjectMapper mapper;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException {
    response.setContentType("application/json;charset=utf-8");
    response.getWriter().write(mapper.writeValueAsString(authentication.getPrincipal()));
  }
}