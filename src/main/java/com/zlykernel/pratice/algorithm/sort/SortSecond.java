package com.zlykernel.pratice.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序 快速排序算法
 * 递归总结
 *  每次递归 方法的参数在变化
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月19日 16:31:00
 */
public class SortSecond {
    /**
     * 归并排序
     * 从小到大
     * @param arrs
     */
    public static void mergeSort(int[] arrs) {
        System.out.println("merge sort before:"+Arrays.toString(arrs));
        mergeSortRecursion(arrs,0,arrs.length-1);
        System.out.println("merge sort after:"+Arrays.toString(arrs));
    }

    private static void mergeSortRecursion(int[] arrs,int start,int end){
        if (start>=end){
            return;
        }
        //获取中间位置
        int mid=(start+end)>>1;
        System.out.println("mergeSortRecursion mid="+mid);
        mergeSortRecursion(arrs,start,mid);
        mergeSortRecursion(arrs,mid+1,end);
        merge(arrs,start,end,mid);
    }

    private static void merge(int[] arrs,int start,int end,int mid){
        int i=start;
        int j=mid+1;
        int k=0;
        int[] temp=new int[mid-start+1];
        while (i<=mid && j<=end){
            if (arrs[i] <= arrs[j]) {
                temp[k++]=arrs[i++];
            }else {
                temp[k++]=arrs[j++];
            }
        }

        int startIndex=i;
        int endIndex=mid;
        if (j <= end) {
            startIndex=j;
            endIndex=end;
        }
        while (startIndex<=endIndex){
            temp[k++]=arrs[startIndex++];
        }
        for (int l = 0; l <mid-start ; l++) {
            arrs[start+l]=temp[l];
        }
    }
    /**
     * 快速排序算法
     * 从小到大
     * @param arrs
     */
    public static void quickSort(int[] arrs) {
        System.out.println("quick sort before:"+Arrays.toString(arrs));
        quickSortRecursion(arrs,0,arrs.length-1);
        System.out.println("quick sort after:"+Arrays.toString(arrs));
    }

    /**
     * 递归
     * @param arrs
     * @param start
     * @param end
     */
    public static void quickSortRecursion(int[] arrs,int start,int end){
        if (start>=end) {
            return;
        }
        //获取分区点
        int partition=partition(arrs,start,end);
        System.out.println("quickSortRecursion partition="+partition);
        //此处递归 是为了
        quickSortRecursion(arrs,start,partition-1);
        quickSortRecursion(arrs,partition+1,end);
    }

    //获取分区节点
    public static int partition(int[] arrs,int start,int end){
        int endVal=arrs[end];
        int i=start;
        for (int j = start; j <end ; ++j) {
            if (arrs[j]<endVal) {
                if (i == j) {
                    ++i;
                }
            } else {
                int tmp=arrs[i];
                arrs[i++]=arrs[j];
                arrs[j]=tmp;
            }
        }
        int tmp=arrs[i];
        arrs[i]=arrs[end];
        arrs[end]=tmp;
        return i;
    }

    public static void main(String[] args) {
//        int[] seeds=Sort.getTestSeed();
//        mergeSort(seeds);
        int[] quickSortSeeds=Sort.getTestSeed();
        quickSort(quickSortSeeds);
    }
}
