package com.zlykernel.pratice.algorithm.queue;

/**
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月08日 20:06:00
 */
public interface Queue<T> {
    /**
     * 入列
     * @param item
     * @return
     */
     T enqueue(T item);

    /**
     * 出列
     * @return
     */
     T dequeue();

    /**
     * 元素个数
     * @return
     */
     int size();

    /**
     * 容量
     * @return
     */
    int capacity();

    /**
     * 是不是为空
     */
    boolean isEmpty();
}
