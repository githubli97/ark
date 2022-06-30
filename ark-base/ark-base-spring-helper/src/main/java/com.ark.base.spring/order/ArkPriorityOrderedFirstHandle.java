package com.ark.base.spring.order;

import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @Classname ArkPriorityOrderedFirstHandle
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Component
public interface ArkPriorityOrderedFirstHandle extends PriorityOrdered {
    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * 获取该节点的顺序值。 较高的值被解释为较低的优先级。
     * 因此，值最低的对象具有最高的优先级(有点类似于Servlet load-on-startup值)。
     * 相同的顺序值将导致受影响对象的任意排序位置。
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    default int getOrder(){
        return LOWEST_PRECEDENCE;
    }
}
