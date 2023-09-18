package com.ark.identify.facade.controller;

import com.ark.identify.service.cmd.account.AccountCmdService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 租户相关接口.
 */
@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {
  @Autowired
  private AccountCmdService accountCmdService;

  /**
   * 根据手机号创建账户.
   */
  @PostMapping("create")
  public ResponseEntity<String> create(String phone) {
    accountCmdService.create(phone);
    return ResponseEntity.ok("success");
  }
}
