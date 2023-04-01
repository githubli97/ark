package com.ark.identify.facade.authorization;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 注销成功结果处理类.
 */
@Component
public class ArkLogOutSuccessHandler implements LogoutSuccessHandler {

  @Override
  public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              Authentication authentication) throws IOException {
    httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
    httpServletResponse.setContentType("application/json;charset=utf-8");
    httpServletResponse.getWriter().write("退出成功，请重新登录");
  }
}
