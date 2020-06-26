package com.zlykernel.pratice.algorithm.skiplist;

import java.util.Random;

/**
 * 跳表
 * @author zhaoliangyuan
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年06月24日 17:12:00
 */
public class SkipList {
    /**
     *最大层数
     */
    private static final int MAX_LEVEL = 16;
    /**
     * 层数
     */
    private int levelCount=1;
    /**
     * 头元素
     */
    private Node head=new Node(MAX_LEVEL);

    /**
     * 随机器
     */
    private Random random = new Random();

    /**
     * 插入
     * @param value
     */
    public void insert(int value){
        int level = head.forwards[0]==null ? 1:randomLevel();
        if (level > levelCount){
            level = ++levelCount;
        }
        Node newNode=new Node(level);
        newNode.data=value;
        Node[] updates=new Node[level];
        for (int i = 0; i <level; i++) {
             updates[i]=head;
        }
        Node pre=head;
        for (int i = levelCount; i >=0 ; i--) {
            while (pre.forwards[i]!=null && pre.forwards[i].data < value){
                //找到前一个节点
                pre = pre.forwards[i];
            }
            if (level > i) {
                updates[i]=pre;
            }
        }
        for (int i = 0; i <level ; i++) {
            newNode.forwards[i]=updates[i].forwards[i];
            updates[i].forwards[i]=newNode;
        }
    }


    /**
     * 随机层数
     * 保存 跳表 的平衡性
     * 即索引层与原始数据层的平衡，避免复杂度退化
     * @return
     */
    public int randomLevel(){
        int level=-1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextInt()%2 == 1){
                level++;
            }
        }
        return level;
    }
    /**
     * 领域模型
     * 跳表节点数据
     * 记录当前节点数据
     *
     */
    public class Node{

        private int data = -1;
        /**
         * 当前节点位置的下一个节点所有层的数据
         */
        private Node[] forwards;
        private int level;

        public Node(int level) {
            this.level = level;
        }
    }
}
