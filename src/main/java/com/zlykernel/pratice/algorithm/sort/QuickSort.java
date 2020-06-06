package com.zlykernel.pratice.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月28日 19:49:00
 */
public class QuickSort {
    /**
     * 快速排序，a是数组，n表示数组的大小
     */
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    /**
     * 快速排序递归函数，p,r为下标
     *
     * @param a 数组
     * @param p 开始位置
     * @param r 结束位置
     */
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        // 获取分区点
        int q = partition(a, p, r);
        System.out.println("partition=" + q);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    /**
     * 处理 p - r 区间的数据
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        /**
         * 该分区的最后一个元素
         * 作为第一个参照点，
         */
        int pivot = a[r];
        /**
         * 该分区第一个元素的下标
         */
        int i = p;
        //从分区第一个开始遍历
        for (int j = p; j < r; ++j) {
            /**
             * 如果该条件一直不成立，说明pivot该区间的最小值，需要将该值的位置换到最前面
             * 如果该成立
             */
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        /**
         * 最后一个元素放到中间
         * 此时的i位置 是小于 pivot 最小位置 即在这个位置之前的元素都小于pivot
         */
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] quickSortSeeds = Sort.getTestSeed();
        System.out.println("quick sort before:" + Arrays.toString(quickSortSeeds));
        quickSort(quickSortSeeds, quickSortSeeds.length);
        System.out.println("quick sort after:" + Arrays.toString(quickSortSeeds));
    }
}
