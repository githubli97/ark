package com.ark.identify.infrastructure.tenant;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantMapper extends BaseMapper<TenantPO> {
}
