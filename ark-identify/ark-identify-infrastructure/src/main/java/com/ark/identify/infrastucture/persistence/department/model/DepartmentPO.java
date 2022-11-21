package com.ark.identify.infrastucture.persistence.department.model;

import com.ark.base.object.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author lihang
 * @since 2022-05-15
 */
@Getter
@Setter
@TableName("ark_identify_department")
public class DepartmentPO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门索引
     */
    private String departmentIndex;

    /**
     * 父部门id
     */
    private Long departmentParentId;

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
