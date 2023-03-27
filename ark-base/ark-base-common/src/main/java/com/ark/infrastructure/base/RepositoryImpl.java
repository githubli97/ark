package com.ark.infrastructure.base;

import com.ark.domain.AbstractEntity;
import com.ark.domain.IRepository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Repository 基类
 * @param <D> domain class
 * @param <M> mapper class
 * @param <P> persistent class
 */
public abstract class RepositoryImpl<D extends AbstractEntity, M extends BaseMapper<P>, P extends AbstractPersistent> extends ServiceImpl<M, P> implements IRepository<D> {
    @Autowired
    private Convertor<D, P> convertor;

    @Override
    public void store(D entity) {
        P po = convertor.DOToPO(entity);
        saveOrUpdate(po);
    }
}
