package com.ark.base.domain.trace;

public abstract class BaseTraceRepository<T extends BaseTrace> {
    public final void store(T baseTrace) {
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


    protected abstract void doStore(T trace);

    protected abstract OperatorId getOperatorId();

    /**
     * 需要基础数据追踪
     */
    protected abstract boolean isBaseTrace();

    /**
     * 插入还是修改
     */
    protected abstract boolean isInsert(T trace);
}
