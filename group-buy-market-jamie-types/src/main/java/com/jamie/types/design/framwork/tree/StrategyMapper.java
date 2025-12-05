package com.jamie.types.design.framwork.tree;

/**
 * @description: StrategyMapper
 * @author: Jamie
 * @date: 03/12/2025 09:52
 */
public interface StrategyMapper<T, D, R> {
    StrategyHandler<T,D,R> get(T requestParameter, D dynamicContext);
}





