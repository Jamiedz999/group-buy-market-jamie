package com.jamie.types.design.framwork.link.model2.handler;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 18:55
 */
public interface ILogicHandler<T,D,R> {

    default R next(T requestParameter, D dynamicContext) {return null;}

    R apply(T requestParameter, D dynamicContext) throws Exception;


}
