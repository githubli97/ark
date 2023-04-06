package com.ark.identify.infrastructure.organization;

import com.ark.infrastructure.base.AbstractPersistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织 po.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ark_identify_organization")
public class OrganizationPo extends AbstractPersistent {
  @Column(name = "tenant_id")
  private Long tenantId;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "responsible_user_id")
  private Long responsibleUserId;
  @Column(name = "parent_id")
  private Long parentId;
}
