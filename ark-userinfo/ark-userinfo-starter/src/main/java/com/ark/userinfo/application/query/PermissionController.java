package com.ark.userinfo.application.query;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@RestController
public class PermissionController {
    @GetMapping("permissionCode")
    public ResponseEntity permissionCode() {
        return ResponseEntity.ok(Lists.newArrayList("1000", "3000", "5000"));

    }
}
