package com.zlykernel.pratice.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月02日 20:43:00
 */
public class RadixSort {
    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        //找到最大元素
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        /**
         * 从个位开始，对数组arr按"指数"进行排序
         * 对进制(除以1，10，100等)进行整除
         */
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * 计数排序-对数组按照"某个位数"进行排序
     *
     * @param arr
     * @param exp 指数 禁止
     */
    public static void countingSort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }

        // 计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            /**
             *
             */
            c[(arr[i] / exp) % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            //在对位置上保存数字
            r[c[(arr[i] / exp) % 10] - 1] = arr[i];
            //该元素对应的个数-1
            c[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
        }
    }
    public static void main(String[] args) {
        int[] seeds=Sort.getTestSeed();
        System.out.println("Radix sort before:" + Arrays.toString(seeds));
        radixSort(seeds);
        System.out.println("Radix sort after:" + Arrays.toString(seeds));
    }
}
