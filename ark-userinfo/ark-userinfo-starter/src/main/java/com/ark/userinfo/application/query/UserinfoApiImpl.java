package com.ark.userinfo.application.query;

import com.ark.userinfo.query.AccountInfo;
import com.ark.userinfo.query.ArkGrantedAuthority;
import com.ark.userinfo.query.UserinfoApi;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@RestController
@AllArgsConstructor
public class UserinfoApiImpl implements UserinfoApi {

  private PasswordEncoder passwordEncoder;

  @Override
  public AccountInfo getUserinfoById(@PathVariable("argType") String argType,
                                     @PathVariable("arg") String arg) {
    log.info("argType: {}, arg: {}", argType, arg);
    return new AccountInfo(arg,
        "张三",
        this.passwordEncoder.encode("123456"),
        Sets.newHashSet(new ArkGrantedAuthority("admin")),
        "https://vben.vvbin.cn/assets/header.1b5fa5f8.jpg");
  }
}
