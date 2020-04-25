package com.zlykernel.pratice.algorithm.link;

/**
 * 单向链表
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年04月23日 11:07:00
 */
public class SinglyLinkedList<E> {

    /**
     * 头部元素
     */
    private Node<E> first;
    /**
     * 尾部元素
     */
    private Node<E> tail;
    /**
     * 大小
     */
    private int size;

    /**
     * 添加元素
     * @Author zhaoliangyuan
     * @Description //TODO
     * @Date 14:52 2020/4/23
     * @Param [value]
     * @return void
     **/
    public void add(E value){
        //新节点
        Node newItem =new Node<E>(value,null);
        //判断是不是第一个元素
        if (first==null){
            first=newItem;
        }else{
            tail.next=newItem;
        }
        //更新尾部节点为新节点
        tail=newItem;
        size++;
    }

    /**
     * 链表反转
     * @Author zhaoliangyuan
     * @Description //TODO
     * @Date 20:41 2020/4/23
     * @Param [list]
     * @return void
     **/
    public void reverse(SinglyLinkedList list){
        //
        Node cur=first;
        if (cur == null){
            return;
        }
        tail = cur;
        Node pre=null;
        while (cur!=null){
            Node tempNext =cur.next;
            cur.next=pre;
            pre=cur;
            cur=tempNext;
        }
        first=pre;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        Node<E> temp=first;
        sb.append("[");
        while (temp!=null){
            sb.append(temp.value.toString());
            sb.append(",");
            temp=temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.toString());
        list.reverse(list);
        System.out.println(list.toString());
    }
    /**
     * 链表 节点 封装 基础操作结构单元
     * @param <E>
     */
    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}

