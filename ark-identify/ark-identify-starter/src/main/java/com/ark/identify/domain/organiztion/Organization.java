package com.ark.identify.domain.organiztion;

import com.ark.domain.AbstractCommonEntity;
import com.ark.identify.domain.user.User;
import com.google.common.base.Preconditions;

/**
 * 组织实体.
 */
public class Organization extends AbstractCommonEntity {

  String description;
  User responsiblePerson;
  Organization parentOrganization;

  /**
   * 获取父组织.
   */
  public Organization getParentOrganization() {
    return parentOrganization;
  }

  /**
   * 设置父组织.
   */
  public void setParentOrganization(Organization parentOrganization) {
    this.parentOrganization = parentOrganization;
  }

  /**
   * 获取责任人.
   */
  public User getResponsiblePerson() {
    return responsiblePerson;
  }

  /**
   * 设置责任人.
   */
  public void setResponsiblePerson(User responsiblePerson) {
    Preconditions.checkArgument(getEnabled(), "禁用组织不允许操作");
    this.responsiblePerson = responsiblePerson;
  }

  @Override
  protected void assertVerifyName(String name) {
    Preconditions.checkNotNull(name, "组织名称必填");
    Preconditions.checkArgument(name.length() < 100 && name.length() > 0, "组织名称应该小于100个字符", name);
  }

  /**
   * 获取组织描述.
   */
  public String getDescription() {
    return description;
  }
}
