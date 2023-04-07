package com.ark.identify.facade.controller;

import com.ark.identify.application.service.tenant.TenantApplicationService;
import com.ark.identify.application.service.tenant.command.CreateTenantByPhoneCommand;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 租户相关接口.
 */
@RestController
@RequestMapping("tenant")
@AllArgsConstructor
public class TenantController {
  private TenantApplicationService tenantApplicationService;

  /**
   * 根据手机号创建用户.
   *
   * @param command 创建用户命令
   */
  @PostMapping("/phone")
  public ResponseEntity create(@RequestBody CreateTenantByPhoneCommand command) {
    tenantApplicationService.createTenantByPhone(command);
    return ResponseEntity.ok().build();
  }
}
