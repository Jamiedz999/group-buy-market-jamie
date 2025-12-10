package com.jamie.types.design.framwork.link.model1;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 18:20
 */
public abstract class AbstractLogicLink<T,D,R> implements ILogicLink<T,D,R>{


    private ILogicLink<T,D,R> next;

    @Override
    public ILogicLink<T, D, R> next() {
        return next;
    }

    @Override
    public ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next) {
        this.next = next;
        return next;
    }

    protected R next(T requestParameter, D dynamicContext) throws Exception{
        return next.apply(requestParameter, dynamicContext);
    }

}
