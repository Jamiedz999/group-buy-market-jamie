package com.jamie.types.design.framwork.link.model2.chain;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 18:34
 */
public interface ILink<E> {

    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();

}