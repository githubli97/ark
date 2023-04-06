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
@Table(name = "ark_identify_account")
public class AccountPo extends AbstractPersistent {
  @Column(name = "username")
  private String username;
  @Column(name = "account_type")
  private String accountType;
  @Column(name = "user_id")
  private Long userId;
}
