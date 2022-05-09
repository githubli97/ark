package com.ark.base.config.mp;

import com.ark.common.util.Constants;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

@Slf4j
public class BaseFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (log.isDebugEnabled()) {
            log.debug("start insert fill ....");
        }

        this.strictInsertFill(metaObject, "isDeleted", () -> Constants.INT_NO, Integer.class); // 起始版本 3.3.3(推荐)
        this.strictInsertFill(metaObject, "version", () -> Constants.ZERO, Long.class); // 起始版本 3.3.3(推荐)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (log.isDebugEnabled()) {
            log.debug("start update fill ....");
        }
    }
}