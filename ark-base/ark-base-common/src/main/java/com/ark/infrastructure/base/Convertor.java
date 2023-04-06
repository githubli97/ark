package com.ark.infrastructure.base;

import com.ark.domain.AbstractEntity;

/**
 * 领域对象和持久化对象转换器.
 *
 * @param <D> 领域对象
 * @param <P> 持久化对象
 */
public interface Convertor<D extends AbstractEntity, P extends AbstractPersistent> {

  /**
   * 待优化, 需要创建泛型对应的子类.
   *
   * @return 持久化对象子类
   */
  P getPersistentObjInstance();

  /**
   * 领域对象转换持久化对象.
   *
   * @param domainObj 领域对象
   * @return 持久化对象
   */
  default P domainObjToPersistentObj(D domainObj) {
    P poInstance = getPersistentObjInstance();
    poInstance.id = domainObj.getId();
    poInstance.creator = domainObj.getCreator();
    poInstance.modifier = domainObj.getModifier();
    poInstance.createdTime = domainObj.getCreatedTime();
    poInstance.modifiedTime = domainObj.getModifiedTime();
    poInstance.isDeleted = false;
    poInstance.version = domainObj.getVersion();
    domainObjToPersistentObj(poInstance, domainObj);
    return poInstance;
  }

  P domainObjToPersistentObj(P persistentObj, D domainObj);
}
