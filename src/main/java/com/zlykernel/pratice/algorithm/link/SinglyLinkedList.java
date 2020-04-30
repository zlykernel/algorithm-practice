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
     * 链表设置环
     */
    public void setCycle(){
        if (tail!=null){
            tail.next=first;
        }
    }

    /**
     * 链表清空环
     */
    public void clearCycle(){
        tail.next=null;
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getTail() {
        return tail;
    }
    public E getTailValue() {
        return tail.value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public void removeTail(){

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

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        //case1:测试单链表反转
//        testListReverse();

        //case2:链表是否有环
        //获取有环列表
        SinglyLinkedList list=mockGetCycleList();
        //方法1 检查有环情况
        boolean hasCycle=exsitCycleInLinkedList(list);
        System.out.println("方法1 检测有环:"+hasCycle);
        list.clearCycle();
        //方法1 检查无环环情况
        boolean hasNoCycle=exsitCycleInLinkedList(list);
        System.out.println("方法1 检测无环:"+hasNoCycle);
//        //方法2 检查有环情况
//        boolean hasCycle=exsitCycleInLinkedList1(list);
//        System.out.println("方法2 检测有环:"+hasCycle);
//        list.clearCycle();
//        //方法2 检查无环环情况
//        boolean hasNoCycle=exsitCycleInLinkedList1(list);
//        System.out.println("方法2 检测无环:"+hasNoCycle);

    }

    /**
     * 检查链表是否有环
     * 使用遍历方式 判断tail节点的next是否指向first节点
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     * @param list
     * @return
     */
    public static boolean exsitCycleInLinkedList(SinglyLinkedList list){
        Node fist=list.getFirst();
        Node tail=list.getTail();
        if (fist==null || tail==null || tail==fist){
            return false;
        }
        return (fist==tail.next);
    }
    /**
     * 检查链表是否有环
     * 使用快慢指针的方式
     *      慢指针
     *      快指针
     *
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     * @param list
     * @return
     */
    public static boolean exsitCycleInLinkedList1(SinglyLinkedList list){
        Node current=list.getFirst();
        if (current==null || current.next==null){
            return false;
        }
        Node quick=current;
        int size=0;
        //当前节点味
        while (current!=null){
            Node tempNextNode=current.next;
            //链表无环
            if(tempNextNode==null || tempNextNode.next==null || quick==null || quick.next==null){
                return false;
            }
            //设置快指针速度
            quick=quick.next.next;
            //链表有环
            if (quick==current){
                System.out.println("检查次数："+size);
                return true;
            }
            //改变循环条件  驱动循环
            current=tempNextNode;
            //
            size++;
        }

        return false;
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
    private static SinglyLinkedList mockGetCycleList(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.setCycle();
        return list;
    }
}

