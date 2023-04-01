package com.ark.identify.facade.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * 登录失败处理器.
 */
@Component
@AllArgsConstructor
public class ArkAuthenticationFailureHandler implements AuthenticationFailureHandler {

  private final ObjectMapper mapper;

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                      AuthenticationException exception) throws IOException {
    response.setContentType("application/json;charset=utf-8");
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.getWriter()
        .write(mapper.writeValueAsString(HttpStatus.UNAUTHORIZED.getReasonPhrase()));
  }
}
