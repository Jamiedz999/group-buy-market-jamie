package com.jamie.types.design.framwork.link.model1;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 18:19
 */
public interface ILogicLink<T,D,R> extends ILoginChainArmory<T,D,R> {

    R apply(T requestParameter, D dynamicContext) throws Exception;


}
