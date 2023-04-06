package com.ark.identify.infrastructure.user;

import com.ark.identify.domain.user.User;
import com.ark.identify.domain.user.UserRepository;
import com.ark.infrastructure.base.RepositoryImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Repository 基类.
 */
@Service
public class UserRepositoryImpl extends RepositoryImpl<User, UserPo>
    implements UserRepository {
  @Lazy
  @Autowired
  protected AccountJpaRepository accountJpaRepository;
  @Autowired
  protected AccountConvertor accountConvertor;

  @Override
  public User store(User entity) {
    if (entity.getAccountList() != null && !entity.getAccountList().isEmpty()) {
      List<AccountPo> accountPoList = entity.getAccountList().stream().parallel()
          .map(accountConvertor::domainObjToPersistentObj)
          .map(item -> item.setUserId(entity.getId()))
          .collect(Collectors.toList());

      accountJpaRepository.saveAll(accountPoList);
    }
    return super.store(entity);
  }
}
