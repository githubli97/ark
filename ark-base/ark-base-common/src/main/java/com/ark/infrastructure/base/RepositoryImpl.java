package com.ark.infrastructure.base;

import com.ark.domain.AbstractEntity;
import com.ark.domain.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository 基类
 * @param <D> domain class
 * @param <P> persistent class
 */
public abstract class RepositoryImpl<D extends AbstractEntity, P extends AbstractPersistent> implements IRepository<D> {
    @Autowired
    protected Convertor<D, P> convertor;
    @Lazy
    @Autowired
    protected JpaRepository<P, Long> jpaRepository;

    @Override
    public D store(D entity) {
        P po = convertor.DOToPO(entity);
        jpaRepository.save(po);
        return entity;
    }
}
