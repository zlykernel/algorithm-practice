package com.zlykernel.pratice.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月15日 20:06:00
 */
public class Sort {
    /**
     * 冒泡排序
     * 从小到大
     * @param args
     */
    public static void bubbleSort(int[] arrs) {
        System.out.println("bubble sort before:"+Arrays.toString(arrs));
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length-i; j++) {
                if (j+1>=arrs.length){
                    break;
                }
                int temp;
                if (arrs[j]>arrs[j+1]){
                    temp=arrs[j+1];
                    arrs[j+1]=arrs[j];
                    arrs[j]=temp;
                }
            }
        }
        System.out.println("bubble sort after :"+Arrays.toString(arrs));
    }

    /**
     * 插入排序
     * @param arrs
     */
    public static void insertionSort(int[] arrs) {
        System.out.println("insertion sort before:"+Arrays.toString(arrs));
        for (int i = 0; i < arrs.length; i++) {
            int temp=arrs[i];
            int j=i-1;
            for (;j>=0;--j){
                if (arrs[j]>temp){
                    arrs[j+1]=arrs[j];
                }else {
                    break;
                }
            }
            arrs[j+1]=temp;
        }
        System.out.println("insertion sort after :"+Arrays.toString(arrs));

    }
    /**
     * 选择排序
     * @param arrs
     */
    public static void selectionSort(int[] arrs) {
        System.out.println("selection sort before:"+Arrays.toString(arrs));

        System.out.println("selection sort after :"+Arrays.toString(arrs));
    }

    public static void main(String[] args) {
        int[] bubbleSeedArray=getTestSeed();
        bubbleSort(bubbleSeedArray);
        System.out.println("------------------------");
        int[] insertionSeedArray=getTestSeed();
        insertionSort(insertionSeedArray);
    }

    /**
     * 测试种子数据
     * @return
     */
    public static int[] getTestSeed(){
        Random random=new Random();
        int[] arrs=new int[10];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i]=random.nextInt(10);
        }
        return arrs;
    }

}
