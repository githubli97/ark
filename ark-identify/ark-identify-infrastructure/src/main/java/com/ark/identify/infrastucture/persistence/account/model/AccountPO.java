package com.ark.identify.infrastucture.persistence.account.model;

import com.ark.base.object.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author lihang
 * @since 2022-05-09
 */
@Getter
@Setter
@TableName("ark_identify_account")
public class AccountPO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 账户状态
     */
    private Integer accountStatus;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码密文
     */
    private String password;

    /**
     * 手机号
     */
    private String phoneNumber;

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
