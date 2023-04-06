package com.ark.identify.infrastructure.organization;

import com.ark.identify.domain.organiztion.Organization;
import com.ark.identify.domain.user.User;
import com.ark.infrastructure.base.Convertor;
import org.springframework.stereotype.Component;

/**
 * 组织实体向持久化对象实体转换.
 */
@Component
public class OrganizationConvertor implements Convertor<Organization, OrganizationPo> {

  @Override
  public OrganizationPo getPersistentObjInstance() {
    return new OrganizationPo();
  }

  @Override
  public OrganizationPo domainObjToPersistentObj(OrganizationPo persistentObj,
                                                 Organization domainObj) {
    persistentObj.setName(domainObj.getName());
    persistentObj.setTenantId(domainObj.getTenantId());
    persistentObj.setDescription(domainObj.getDescription());

    User responsibleUser = domainObj.getResponsibleUser();
    if (responsibleUser != null) {
      persistentObj.setResponsibleUserId(responsibleUser.getId());
    }
    Organization parentOrganization = domainObj.getParentOrganization();
    if (parentOrganization != null) {
      persistentObj.setParentId(parentOrganization.getId());
    }
    return persistentObj;
  }
}
