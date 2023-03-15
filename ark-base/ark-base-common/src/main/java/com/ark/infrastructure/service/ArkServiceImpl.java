package com.ark.infrastructure.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @param <M> mapper
 * @param <P> po
 */
public class ArkServiceImpl<M extends BaseMapper<P>, P> extends ServiceImpl<M, P> {
}