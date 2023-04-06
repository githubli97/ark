package com.ark.identify.infrastructure.user;

import com.ark.identify.domain.user.User;
import com.ark.identify.domain.user.valueobject.UserGenderEnum;
import com.ark.infrastructure.base.Convertor;
import org.springframework.stereotype.Component;

/**
 * 用户实体向持久化对象实体转换.
 */
@Component
public class UserConvertor implements Convertor<User, UserPo> {

  @Override
  public UserPo getPersistentObjInstance() {
    return new UserPo();
  }

  @Override
  public UserPo domainObjToPersistentObj(
      UserPo persistentObj, User domainObj) {
    persistentObj.setTenantId(domainObj.getTenantId());
    persistentObj.setName(domainObj.getName());
    persistentObj.setPassword(domainObj.getPassword().getValue());
    persistentObj.setEmail(domainObj.getEmail());
    persistentObj.setPhone(domainObj.getPhone());

    UserGenderEnum gender = domainObj.getGender();
    if (gender != null) {
      persistentObj.setGender(gender.name());
    }

    persistentObj.setBirthday(domainObj.getBirthday());
    persistentObj.setOrganizationId(domainObj.getOrganization().getId());
    return persistentObj;
  }
}
