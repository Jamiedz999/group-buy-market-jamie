package com.jamie.types.design.framwork.link.model1;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 18:20
 */
public interface ILoginChainArmory<T,D,R> {

    ILogicLink<T,D,R> next();

    ILogicLink<T,D,R> appendNext(ILogicLink<T,D,R> next);

}
