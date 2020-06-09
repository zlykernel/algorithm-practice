package com.zlykernel.pratice.algorithm.search;

/**
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月09日 20:59:00
 */
public class BinarySearch {

    public static int binarySearch(int[] arr,int target){
        return binarySearchReversion(arr,0,arr.length,target);
    }

    public static int binarySearchReversion(int[] arr,int start,int end,int target){
        if (start > end){
            return -1;
        }
        int mid=start+((end-start)>>2);
        if (arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return binarySearchReversion(arr,mid+1,end,target);
        }else{
            return binarySearchReversion(arr,start,mid-1,target);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,5,6};
        int index=binarySearch(arr,5);
        System.out.println(""+index);
    }
}
