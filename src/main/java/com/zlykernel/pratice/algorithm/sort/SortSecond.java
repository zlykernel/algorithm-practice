package com.zlykernel.pratice.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序 快速排序算法
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
        mergeSortRecursion(arrs,0,arrs.length);
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
    public static void quickSort() {

    }

    public static void partition(){

    }

    public static void main(String[] args) {
        int[] seeds=Sort.getTestSeed();
        mergeSort(seeds);
    }
}
