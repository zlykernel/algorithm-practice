package com.zlykernel.pratice.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 迭代
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月11日 19:46:00
 */
public class Recursion {

    /**
     * 深度
     */
    private static AtomicInteger DEPTH=new AtomicInteger();
    private static AtomicInteger READ_CACHE_DEPTH=new AtomicInteger();
    private static Map<Integer,Integer> CACHE_RESULT=new HashMap<Integer, Integer>();

    /**
     * 题目:
     *      上台阶:假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
 *
     * @return
     */
    public static int upperBench(int stepNum){
        DEPTH.addAndGet(1);
        //如果只有1个台阶，只有1种走法 即跨1个台阶
        if (stepNum==1){
            return 1;
        }
        //如果只有2个台阶，有2种走法 即 走法1：跨2个台阶一次 走法2：一次跨一个台阶走两步
        if (stepNum==2){
            return 2;
        }
        Integer temp =CACHE_RESULT.get(stepNum);
        Integer methodCount=null;
        //使用缓存 解决重复计算问题
        if (temp==null){
            methodCount=upperBench(stepNum-1)+upperBench(stepNum-2);
            CACHE_RESULT.put(stepNum,methodCount);
        }else {
            READ_CACHE_DEPTH.addAndGet(1);
            methodCount=temp;
        }
        return methodCount;
    }

    public static void main(String[] args) {
        int methodCount=upperBench(2);
        System.out.println("方式数量:"+methodCount+";递归次数"+DEPTH.toString()+";读取缓存次数："+READ_CACHE_DEPTH);
    }
}
