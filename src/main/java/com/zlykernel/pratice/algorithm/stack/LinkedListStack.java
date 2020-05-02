package com.zlykernel.pratice.algorithm.stack;

import com.zlykernel.pratice.algorithm.link.SinglyLinkedList;

import java.util.LinkedList;

/**
 * 栈基于链表
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年04月28日 10:43:00
 */
public class LinkedListStack<E> {
    /**
     * 如果使用单向链表的化需要迭代
     * fist 为栈底 tail为栈顶
     */
//    private SinglyLinkedList<E> list;
    private LinkedList<E> linkedList;

    public LinkedListStack() {
//        list=new SinglyLinkedList<E>();
        linkedList=new LinkedList<E>();
    }

    /**
     * 随着 push fist向前增长第一个first为最后一个元素 即为栈底
     * @param item
     */
    public void push(E item){
        linkedList.addFirst(item);
    }

    /**
     *此时第一个元素为最后一个添加的袁术
     * @return
     */
    public E pop(){
        E result=linkedList.removeFirst();
        return result;
    }

    public int size(){
        return linkedList.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }
    public static void main(String[] args) {
        testBaseForStack();
    }

    private static void testBaseForStack(){
        LinkedListStack<String> stack = new LinkedListStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.size());
        while (!stack.isEmpty()){
            String temp=stack.pop();
            System.out.println("弹出元素:"+temp+"栈剩余元素个数:"+stack.size());
        }
    }
}
