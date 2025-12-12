package com.jamie.types.design.framework.tree;

/**
 * @description:StrategyHandler
 * @author: Jamie
 * @date: 03/12/2025 09:53
 */
public interface StrategyHandler<T,D,R> {

    StrategyHandler DEFAULT = (T, D) -> null;

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
