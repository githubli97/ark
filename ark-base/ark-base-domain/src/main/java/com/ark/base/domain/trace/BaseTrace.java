package com.ark.base.domain.trace;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseTrace {
    protected OperatorId creater;

    protected LocalDateTime createTime;

    protected OperatorId modifier;

    protected LocalDateTime modifyTime;

    public void initInsert(OperatorId operatorId) {
        this.creater = operatorId;
        this.createTime = LocalDateTime.now();
        this.modifier = operatorId;
        this.modifyTime = this.createTime;
    }

    public void initUpdate(OperatorId operatorId) {
        this.modifier = operatorId;
        this.modifyTime = LocalDateTime.now();
    }
}
