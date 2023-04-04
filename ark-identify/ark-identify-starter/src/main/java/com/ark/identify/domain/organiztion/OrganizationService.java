package com.ark.identify.domain.organiztion;

import com.ark.domain.AbstractCommonService;
import com.ark.identify.domain.user.User;
import com.ark.identify.domain.user.UserService;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 组织领域服务类.
 */
@Service
@AllArgsConstructor
public class OrganizationService extends AbstractCommonService<Organization> {
  private OrganizationFactory organizationFactory;
  private UserService userService;

  /**
   * 创建租户对应的组织, 并设置责任人.
   *
   * @param name 组织名称.
   */
  public Organization createTenantOrganization(String name, String phone) {
    Organization organization = organizationFactory.createOrganization(name);
    // 创建用户
    User user = userService.createUser(name, phone, organization);
    // 给组织绑定责任人
    organization.setResponsiblePerson(user);

    repository.store(organization);
    return organization;
  }

  /**
   * 给组织设置责任人.
   */
  public void setResponsiblePerson(Organization organization, User user) {
    organization.setResponsiblePerson(user);
    repository.store(organization);
  }

  /**
   * 创建子组织.
   */
  public Organization createSubOrganization(Organization parentOrganization, String name) {
    Organization organization = organizationFactory.createOrganization(name);
    organization.setParentOrganization(parentOrganization);
    return organization;
  }
}