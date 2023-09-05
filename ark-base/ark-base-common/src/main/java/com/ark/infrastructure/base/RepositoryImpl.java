package com.ark.infrastructure.base;

import com.ark.domain.AbstractEntity;
import com.ark.domain.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository 基类.
 *
 * @param <D> domain class
 * @param <P> persistent class
 */
public abstract class RepositoryImpl<D extends AbstractEntity, P extends AbstractPersistent>
    implements
    Repository<D> {

  @Autowired
  protected Convertor<D, P> convertor;
  @Lazy
  @Autowired
  protected ReactiveCrudRepository<P, Long> jpaRepository;

  @Override
  public D store(D entity) {
    P po = convertor.domainObjToPersistentObj(entity);
    jpaRepository.save(po);
    return entity;
  }
}
