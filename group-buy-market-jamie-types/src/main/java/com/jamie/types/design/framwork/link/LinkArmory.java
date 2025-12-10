package com.jamie.types.design.framwork.link;

import com.jamie.types.design.framwork.link.model2.chain.BusinessLinkedList;
import com.jamie.types.design.framwork.link.model2.handler.ILogicHandler;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 19:00
 */

public class LinkArmory<T, D, R> {

    private final BusinessLinkedList<T, D, R> logicLink;

    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        logicLink = new BusinessLinkedList<>(linkName);
        for (ILogicHandler<T, D, R> logicHandler: logicHandlers){
            logicLink.add(logicHandler);
        }
    }

    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

}
