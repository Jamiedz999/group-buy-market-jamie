package com.jamie.types.design.framwork.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 09:55
 */
public abstract class AbstractStrategyRouter<T,D,R> implements StrategyMapper<T,D,R>, StrategyHandler<T,D,R>{

    @Getter
    @Setter
    protected StrategyHandler<T,D,R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R router(T requestParameter, D dynamicContext) throws Exception{
        StrategyHandler<T,D,R> strategyHandler = get(requestParameter, dynamicContext);
        if (null != strategyHandler) return strategyHandler.apply(requestParameter, dynamicContext);
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }


}
