package com.ark.identify.infrastucture.persistence.tenant.model;

import com.ark.base.object.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihang
 * @since 2022-05-10
 */
@Getter
@Setter
@TableName("ark_identify_tenant")
public class TenantPO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 租户状态
     */
    private Integer tenantStatus;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


}
