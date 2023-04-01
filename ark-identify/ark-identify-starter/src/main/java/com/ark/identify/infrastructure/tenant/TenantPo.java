package com.ark.identify.infrastructure.tenant;

import com.ark.infrastructure.base.AbstractPersistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户数据库层对象映射.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ark_identify_tenant")
public class TenantPo extends AbstractPersistent {

  @Column(name = "name")
  private String name;
}
