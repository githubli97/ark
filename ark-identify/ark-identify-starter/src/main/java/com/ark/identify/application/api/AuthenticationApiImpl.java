package com.ark.identify.application.api;

import com.ark.identify.AuthenticationApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@RestController
public class AuthenticationApiImpl implements AuthenticationApi {

  @Override
  public boolean authentication(String serviceName, String uri) {
    return true;
  }
}
