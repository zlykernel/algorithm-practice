package com.zlykernel.pratice.algorithm.search;

/**
 * 二分查找 2
 *
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月09日 20:59:00
 */
public class BinarySearchSecond {

    /**
     * 变体一：查找第一个值等于给定值的元素
     * @return
     */
    public static int SearchFirstOneEq(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && a[low] == value) {
            return low;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,3,3,3,3,5,5,5,7,8,9,};
        System.out.println(SearchFirstOneEq(a,a.length,5));
    }
}
