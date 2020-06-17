package com.zlykernel.pratice.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 * 利用新数组的下标来记录原来的值
 * 利用新数组的下标对应值来记录原来的值的个数
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月01日 20:39:00
 */
public class CountingSort {
    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围 即最大的数
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            //其中a[i] 代表新数组的下标
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i < max + 1; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        /**
         * 计算排序的关键步骤了，有点难理解
         * 倒序遍历 即从最大的
         */
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝会a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] seeds=Sort.getTestSeed();
        System.out.println("Count sort before:" + Arrays.toString(seeds));
        countingSort(seeds,seeds.length);
        System.out.println("Count sort after:" + Arrays.toString(seeds));
    }

}