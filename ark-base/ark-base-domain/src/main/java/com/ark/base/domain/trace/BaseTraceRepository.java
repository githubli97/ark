package com.ark.base.domain.trace;

public interface BaseTraceRepository<T extends BaseTrace> {
    default void store(T baseTrace) {
        if (isBaseTrace()) {
            OperatorId operatorId = getOperatorId();
            if (isInsert(baseTrace)) {
                baseTrace.initInsert(operatorId);
            } else {
                baseTrace.initUpdate(operatorId);
            }
        }
        doStore(baseTrace);
    }


    void doStore(T baseTrace);

    OperatorId getOperatorId();

    /**
     * 需要基础数据追踪
     */
    boolean isBaseTrace();

    /**
     * 插入还是修改
     */
    boolean isInsert(T trace);
}
