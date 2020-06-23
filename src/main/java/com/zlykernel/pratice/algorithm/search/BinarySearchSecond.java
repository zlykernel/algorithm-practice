package com.zlykernel.pratice.algorithm.search;

/**
 * 二分查找 2
 * 终止条件、区间上下界更新方法、返回值选择
 * 上界 大于
 * 下界 小于
 *
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月09日 20:59:00
 */
public class BinarySearchSecond {

    /**
     * 变体一：查找第一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchFirstOneEq(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            /**
             * 临界值考虑:为何mid是大于等于
             */
            if (a[mid] >= value) {
                //注意区域值修改
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        /**
         * 为何去low
         * 当给定值有多个的时候(已排序)，取下标最小的。
         */
        if (low < n && a[low] == value) {
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchLastOneEq(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchLastOneGE(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 变体四：查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int searchLastOneLE(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 3, 3, 3, 5, 5, 5, 7, 8, 9,};
//        System.out.println(searchFirstOneEq(a, a.length, 3));
//        System.out.println(searchLastOneEq(a, a.length, 3));
//        System.out.println(searchLastOneGE(a, a.length, 3));
        System.out.println(searchLastOneLE(a, a.length, 3));
    }
}
