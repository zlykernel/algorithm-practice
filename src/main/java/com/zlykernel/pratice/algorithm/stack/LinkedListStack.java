package com.zlykernel.pratice.algorithm.stack;

import com.zlykernel.pratice.algorithm.link.SinglyLinkedList;

/**
 * 栈基于链表
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年04月28日 10:43:00
 */
public class LinkedListStack<E> {
    private SinglyLinkedList<E> list;
    private int size;

    public LinkedListStack() {
        list=new SinglyLinkedList<E>();
    }

    public void push(E item){
        list.add(item);
        size=list.getSize();
    }

    public E pop(){
        E result=list.getTailValue();
        list.removeTail();
        size=list.getSize();
        return result;
    }

    public static void main(String[] args) {
        testBaseForStack();
    }

    private static void testBaseForStack(){
        LinkedListStack<String> stack = new LinkedListStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.size);
        String temp=stack.pop();
        while (temp!=null){
            System.out.println("弹出元素:"+temp+"栈剩余元素个数:"+stack.size);
            temp=stack.pop();
        }
    }
}
