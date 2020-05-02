package com.zlykernel.pratice.algorithm.stack;

import java.util.Arrays;

/**
 * 栈基于数组
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年04月28日 10:43:00
 */
public class ArrayStack<E> {
    /**
     * 关键数据结构
     */
    private Object[] arrays;

    /**
     * 元素个数
     */
    private int size;

    /**
     *栈顶位置
     */
    private int topPoint=-1;

    /**
     * 元素个数
     */
    private int elementCount;


    public ArrayStack() {
        //初始化数组4个
        arrays=new Object[4];
    }

    /**
     * 问题:
     * 1.扩容考虑
     * @param item
     */
    public void push(E item){
        if (item == null){
            return ;
        }
        /**
         * 使用++i的原因是 topPoint是从-1开始 所以要先运算
         */
        arrays[++topPoint]=item;
        size=topPoint+1;
    }
    public E pop(){
        //临界值判断，当站内没有元素时判断
        if (arrays[0]==null){
            return null;
        }
        E result = (E)arrays[topPoint];
        //将弹出元素 删除
        arrays[topPoint]=null;
        //栈顶指针下移
        topPoint--;
        //栈内元素个数-1
        size--;
        return result;
    }

    /**
     * 不设置头部指针
     * 使用容量来计算头部指针
     * @param item
     * @return
     */
    public E pushUpgrade(E item){
        ensureCapacity(elementCount+1);
        arrays[elementCount++]=item;
        return item;
    }

    public E popUpgrade(){
        E result=peekUpgrade();
        removeElementAt(size()-1);
        return result;
    }

    public E peekUpgrade(){
        int len=size();
        if (len < 1){
            return null;
        }
        return (E)arrays[len-1];
    }

    private void removeElementAt(int index){
        elementCount--;
        arrays[index]=null;
    }

    /**
     * 确定容量
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity){
        if (minCapacity>arrays.length){
            scaleCapacity(minCapacity);
        }
    }

    /**
     * 扩容
     */
    private void scaleCapacity(int minCapacity){
        int oldCapacity=arrays.length;
        //扩大原来容量的2倍
        int newCapacity=oldCapacity+oldCapacity;
        arrays=Arrays.copyOf(arrays,newCapacity);
    }

    public int size(){
        return elementCount;
    }

    public int getStackCapacity(){
        return arrays.length;
    }

    public boolean isEmpty(){
        return size() == 0;
    }


    public static void main(String[] args) {
//        testBaseForStack();
//        test();
//        testUpgrade();
        testScale(10);
    }

    private static void test(){
        int i=0;
        int a =++i;
        System.out.println("a="+a+";i="+i);
        int j=0;
        int b =j++;
        System.out.println("b="+b+";j="+j);
    }

    private static void testBaseForStack(){
        ArrayStack<String> stack = new ArrayStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println();
        //使用数量来迭代
        while (stack.size>0){
            String temp=stack.pop();
            System.out.println("弹出元素:"+temp+"栈剩余元素个数:"+stack.size);
        }
    }

    private static void testUpgrade(){
        ArrayStack<String> stack = new ArrayStack<String>();
        stack.pushUpgrade("a");
        stack.pushUpgrade("b");
        stack.pushUpgrade("c");
        System.out.println(stack.elementCount);
        while (!stack.isEmpty()){
            String temp=stack.popUpgrade();
            System.out.println("弹出元素:"+temp+"栈剩余元素个数:"+stack.elementCount);
        }
    }

    /**
     * 测试扩容
     */
    private static void testScale(int increment){
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < increment; i++) {
            stack.pushUpgrade(i);
            System.out.println("压入元素="+i+";栈内元素个数="+stack.size()+" ; 栈容量= "+stack.getStackCapacity());
        }
    }
}
