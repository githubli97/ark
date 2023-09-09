package com.ark.identify.domain.user;

import com.ark.core.base.BaseCommonEntity;
import com.ark.core.tag.TagEntity;
import java.util.List;

/**
 * 账户领域服务.
 */
public interface AccountService extends BaseCommonEntity, TagEntity {
  /**
   * 登录.
   *
   * @return 用户
   */
  List<User> signin();

  /**
   * 注册.
   */
  Account signup();
}
