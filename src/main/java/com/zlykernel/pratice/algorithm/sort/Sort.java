package com.zlykernel.pratice.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡 插入 选择
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月15日 20:06:00
 */
public class Sort {
    /**
     * 冒泡排序
     * 从小到大
     * @param arrs
     */
    public static void bubbleSort(int[] arrs) {
        System.out.println("bubble sort before:"+Arrays.toString(arrs));
        //
        for (int i = 0; i < arrs.length; i++) {
            //内层循环是为为了找到该次最大的元素
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
     * 从小到大
     * @param arrs
     */
    public static void insertionSort(int[] arrs) {
        System.out.println("insertion sort before:"+Arrays.toString(arrs));
        for (int i = 0; i < arrs.length; i++) {
            //待排序元素
            int temp=arrs[i];
            //当前已排序中的最大元素
            int j=i-1;
            /**
             * 第一个元素不做排序
             * 数据移动
             * 获取插入位置j
             */
            for (;j>=0;--j){
                /**
                 * 如果最大元素比待排序元素大，待排元素需要向前移动
                 * 如果最大元素比待排序元素小，待排元素不需要移动
                 */
                if (arrs[j]>temp){
                    //数据移动
                    arrs[j+1]=arrs[j];
                }else {
                    break;
                }
            }
            //插入排序位置
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
        for (int i = 0; i < arrs.length; i++) {
            //查找最小值
            int min=i;
            //从第二个位置开始
            for (int j=i+1;j < arrs.length;j++){
                //在未排序区域中 找到最小元素
                if (arrs[j]<arrs[min]){
                    min=j;
                }
            }
            //交换 最小的元素
            int temp=arrs[i];
            arrs[i]=arrs[min];
            arrs[min]=temp;
        }
        System.out.println("selection sort after :"+Arrays.toString(arrs));
    }

    public static void main(String[] args) {
        int[] bubbleSeedArray=getTestSeed();
        bubbleSort(bubbleSeedArray);
        System.out.println("------------------------");
        int[] insertionSeedArray=getTestSeed();
        insertionSort(insertionSeedArray);
        System.out.println("------------------------");
        int[] selectionSeedArray=getTestSeed();
        selectionSort(selectionSeedArray);
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
