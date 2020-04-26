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
     * 设置环为链表
     */
    public void setAnnular(){
        tail.next=first;
    }


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
     * 反转本质是改变节点之间的关系
     * 要找到影响最小的范围(节点数和关系数)
     * 最小单元思考问题
     * 否则会增加思考难度
     * @Author zhaoliangyuan
     * @Description //TODO
     * @Date 20:41 2020/4/23
     * @Param [list]
     * @return void
     **/
    public void reverse(SinglyLinkedList list){
        //当前节点
        Node cur=first;
        if (cur == null){
            return;
        }
        tail = cur;
        /**
         *  前驱节点
         * 为什么要定义前驱节点?
         * 原因是反转时，前驱节点通过节点自身的属性无法获取，所有要定义临时变量。
         */
        Node pre=null;
        /**
         * 为什么此处要使用cur！=null 作为边界条件而不是cur.next!=null
         * 因为循环体中
         */
        while (cur!=null){
            /**
             * 此处定义tempNext临时变量的原因？
             * 因为反转会改变当前节点 next指针，所以要快照该节点内容
             * 如果不快照，next指针改变为pre节点，后续循环关系断裂。
             */
            Node tempNext =cur.next;
            /**
             * 将后续节点关系改变执行前驱节点
             */
            cur.next=pre;
            //设置将当前处理的节点 赋值给前驱节点 以便下一次反转处理使用
            pre=cur;
            //将洗一次节点赋值给当前节点 这是循环继续的驱动条件
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
//            System.out.println(sb.toString());
        }
        sb.append("]");
        return sb.toString();
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

    public static void main(String[] args) {
//        testListReverse();
        testAnnularList();
    }

    /**
     *链表基础/反转
     * 测试方法
     */
    private static void testListReverse(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println("链表打印："+list.toString());
        list.reverse(list);
        System.out.println("链表反转打印："+list.toString());
    }

    /**
     * 环形列表 测试方法
     * 测试方法
     * @return
     */
    private static SinglyLinkedList testAnnularList(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.setAnnular();
//        System.out.println("环形链表打印："+list.toString());
        return list;
    }
}

