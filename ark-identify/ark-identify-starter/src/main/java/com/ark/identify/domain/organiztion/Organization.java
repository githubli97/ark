package com.ark.identify.domain.organiztion;

import com.ark.domain.AbstractCommonEntity;
import com.ark.identify.domain.user.User;
import com.google.common.base.Preconditions;
import lombok.Getter;

/**
 * 组织实体.
 */
@Getter
public class Organization extends AbstractCommonEntity {
  public static final Organization ROOT_PARENT_ORGANIZATION;

  static {
    ROOT_PARENT_ORGANIZATION = new Organization();
    ROOT_PARENT_ORGANIZATION.id = 0L;
  }

  Long tenantId;
  String description;
  User responsibleUser;
  Organization parentOrganization;

  /**
   * 设置父组织.
   */
  public void setParentOrganization(Organization parentOrganization) {
    Preconditions.checkArgument(getEnabled(), "禁用组织不允许操作");
    this.parentOrganization = parentOrganization;
  }

  /**
   * 设置责任人.
   */
  public void setResponsibleUser(User responsibleUser) {
    Preconditions.checkArgument(getEnabled(), "禁用组织不允许操作");
    this.responsibleUser = responsibleUser;
  }

  @Override
  protected void assertVerifyName(String name) {
    Preconditions.checkNotNull(name, "组织名称必填");
    Preconditions.checkArgument(name.length() < 100 && name.length() > 0, "组织名称应该小于100个字符", name);
  }
}
