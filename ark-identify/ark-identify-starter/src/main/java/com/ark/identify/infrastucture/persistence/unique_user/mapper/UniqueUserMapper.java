package com.ark.identify.infrastucture.persistence.unique_user.mapper;

import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 唯一用户表，表明账户和租户的关系 Mapper 接口
 * </p>
 *
 * @author lihang
 * @since 2022-05-10
 */
public interface UniqueUserMapper extends BaseMapper<UniqueUserPO> {

}
