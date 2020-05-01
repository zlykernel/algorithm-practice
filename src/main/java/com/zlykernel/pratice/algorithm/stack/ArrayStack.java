package com.zlykernel.pratice.algorithm.stack;

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

    public E pushUpgrade(E item){
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

    public int size(){
        return elementCount;
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

    public static void main(String[] args) {
//        testBaseForStack();
//         test();
        testUpgrade();


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
        System.out.println(stack.size);
        String temp=stack.pop();
        while (temp!=null){
            System.out.println("弹出元素:"+temp+"栈剩余元素个数:"+stack.size);
            temp=stack.pop();
        }
    }

    private static void testUpgrade(){
        ArrayStack<String> stack = new ArrayStack<String>();
        stack.pushUpgrade("a");
        stack.pushUpgrade("b");
        stack.pushUpgrade("c");
        System.out.println(stack.elementCount);
        String temp=stack.popUpgrade();
        while (temp!=null){
            System.out.println("弹出元素:"+temp+"栈剩余元素个数:"+stack.elementCount);
            temp=stack.popUpgrade();
        }
    }
}
