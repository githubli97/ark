package com.ark.identify.domain.user;

import com.ark.domain.AbstractEntityFactory;
import com.ark.identify.domain.organiztion.Organization;
import com.ark.identify.domain.user.valueobject.AccountTypeEnum;
import com.ark.identify.domain.user.valueobject.Password;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户实体工厂.
 */
@Service
@AllArgsConstructor
public class UserFactory extends AbstractEntityFactory<User> {
  /**
   * 创建员工,默认初始化审计相关字段.
   *
   * @param name 员工名称
   * @return 员工实体
   */
  public User createUserByPhone(String name, String phone, Organization organization) {
    User user = createAbstractEntity();

    user.organization = organization;
    user.phone = phone;
    user.password = new Password("password");
    user.setName(name);

    Account account = new Account();
    account.accountType = AccountTypeEnum.PHONE;
    account.username = phone;

    user.accountList = Lists.newArrayList(account);
    return user;
  }


  @Override
  protected User getInstance() {
    return new User();
  }
}
