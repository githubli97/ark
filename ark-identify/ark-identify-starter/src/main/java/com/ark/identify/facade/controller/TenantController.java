package com.ark.identify.facade.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 租户相关接口.
 */
@RestController
@RequestMapping("tenant")
@AllArgsConstructor
public class TenantController {

  /**
   * 根据手机号创建租户.
   */
  @PostMapping("/phone")
  public ResponseEntity create() {
    return ResponseEntity.ok().build();
  }
}
