package com.zlykernel.pratice.algorithm.search;

/**
 * 二分查找
 * 基于有序数组
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月09日 20:59:00
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        return binarySearchReversion(arr, 0, arr.length, target);
    }

    /**
     * 递归 二分查找
     *
     * @param arr
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int binarySearchReversion(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        //去中间数注意：避免相加超过最大值限制。
        int mid = start + ((end - start) >> 2);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchReversion(arr, mid + 1, end, target);
        } else {
            return binarySearchReversion(arr, start, mid - 1, target);
        }
    }

    /**
     * 循环 二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchLoop(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        int mid =start+((end - start) >> 2);
        if (arr[mid] == target){
            return mid;
        }
        while ( arr[mid] != target){
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 6};
        int index = binarySearch(arr, 5);
        System.out.println("" + index);
    }
}
