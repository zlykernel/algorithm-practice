package com.zlykernel.pratice.algorithm.queue;

import java.util.Arrays;

/**
 * 队列
 */
public class ArrayQueue<T> {

    private Object[] arrays;
    /**
     * 出列位置
     */
    private int first=-1;

    private int tail=-1;
    /**
     * 元素个数
     */
    private int elementCount;

    public ArrayQueue(int initCapactiy) {
        this.arrays = new Object[initCapactiy];
    }

    /**
     * 入列
     * @param item
     * @return
     */
    public T enqueue(T item){
        int index=++tail;
        ensureCapacity(index+1);
        arrays[index]=item;
        elementCount++;
        return item;
    }
    /**
     * 出列
     * @return
     */
    public T dequeue(){
        int index=++first;
        T result=(T)arrays[index];
        arrays[index]=null;
        elementCount--;
        return result;
    }

    public int size(){
        return elementCount;
    }
    public int capacity(){
        return arrays.length;
    }
    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return elementCount==0;
    }
    /**
     * 检查容量
     */
    private void ensureCapacity(int minCapacity){
        if(minCapacity>arrays.length){
            scaleCapacity();
        }
    }

    /**
     * 移动数据
     */
    private void moveData(){

    }
    /**
     * 扩容
     */
    private void scaleCapacity(){
        int newLength=arrays.length*2;
        arrays=Arrays.copyOf(arrays,newLength);
    }



    public static void main(String[] args) {
        testBase();
    }
    private static void testBase(){
        ArrayQueue<String> arrayQueue=new ArrayQueue<String>(5);
        System.out.println("入列开始");
        for (int i = 0; i <6 ; i++) {
            String val=arrayQueue.enqueue(String.valueOf(i));
            System.out.println("入列元素:"+val+";队列元素数量:"+arrayQueue.size()+";队列容量数量:"+arrayQueue.capacity());
        }
        System.out.println("出列开始");
        while (!arrayQueue.isEmpty()){
            String val=arrayQueue.dequeue();
            System.out.println("入列元素:"+val+";队列元素数量:"+arrayQueue.size()+";队列容量数量:"+arrayQueue.capacity());
        }
    }

}
