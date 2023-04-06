package com.ark.identify.infrastructure.user;

import com.ark.infrastructure.base.AbstractPersistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户 po.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ark_identify_user")
public class UserPo extends AbstractPersistent {
  @Column(name = "tenant_id")
  private Long tenantId;
  @Column(name = "name")
  private String name;
  @Column(name = "password")
  private String password;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;
  @Column(name = "gender")
  private String gender;
  @Column(name = "birthday")
  private LocalDate birthday;
  @Column(name = "organization_id")
  private Long organizationId;
}
