package com.ark.identify.domain.user;

import com.ark.identify.domain.organiztion.Organization;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 组织领域服务类.
 */
@Service
@AllArgsConstructor
public class UserService {
  private UserFactory userFactory;
  private UserRepository userRepository;

  /**
   * 用户组织.
   *
   * @param name 用户名称.
   */
  public User createUser(String name, String phone, Organization organization) {
    User user = userFactory.createUserByPhone(name, phone, organization);

    userRepository.store(user);
    return user;
  }
}