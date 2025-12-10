package com.jamie.types.design.framwork.link.model2.chain;

import com.jamie.types.design.framwork.link.model2.handler.ILogicHandler;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 19:01
 */
public class BusinessLinkedList<T,D,R> extends LinkedList<ILogicHandler<T,D,R>> implements ILogicHandler<T,D,R> {


    public BusinessLinkedList(String name) {
        super(name);
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        Node<ILogicHandler<T, D, R>> current = this.first;
        do {
            ILogicHandler<T, D, R> item = current.item;
            R apply = item.apply(requestParameter, dynamicContext);
            if (null != apply) return apply;

            current = current.next;
        } while (null != current);

        return null;
    }

}

