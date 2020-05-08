package com.zlykernel.pratice.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 链式队列
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月08日 20:05:00
 */
public class LinkedListQueue<T> implements Queue<T> {

    private LinkedList<T> list;

    public LinkedListQueue() {
        this.list = new LinkedList<T>();
    }

    /**
     * 入列
     *
     * @param item
     * @return
     */
    public T enqueue(T item) {
        list.add(item);
        return item;
    }

    /**
     * 出列
     *
     * @return
     */
    public T dequeue() {
        T result=list.removeFirst();
        return result;
    }

    /**
     * 元素个数
     *
     * @return
     */
    public int size() {
        return list.size();
    }

    /**
     * 容量
     *
     * @return
     */
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        LinkedListQueue<String> queue=new LinkedListQueue<String>();
        System.out.println("入列开始");
        for (int i = 0; i <6 ; i++) {
            String val=queue.enqueue(String.valueOf(i));
            System.out.println("入列元素:"+val+";队列元素数量:"+queue.size()+";队列容量数量:"+queue.capacity());
        }
        System.out.println("出列开始");
        while (!queue.isEmpty()){
            String val=queue.dequeue();
            System.out.println("入列元素:"+val+";队列元素数量:"+queue.size()+";队列容量数量:"+queue.capacity());
        }

    }
}
