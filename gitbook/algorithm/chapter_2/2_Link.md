**问题**
+ 链表的应用

   + LRU 缓存淘汰算法策略

先进先出策略 FIFO（First In，First Out）

最少使用策略 LFU（Least Frequently Used）

最近最少使用策略 LRU（Least Recently Used

```
什么是缓存?
缓存是一种提高数据读取性能的技术，在硬件设计、软件开发中都有着非常广泛的应用，CPU 缓存、数据库缓存、浏览器缓存等等。
什么是缓存淘汰机制？
因为缓存资源有限，不能无限制放置数据，当数据超出缓存容量时，就要淘汰部分数据，淘汰哪些数据即淘汰数据的优先级，称之为缓存淘汰机制。

```

+ 链表的类型

   + 单链表
  ![](../image/img2-2-1.jpg)
   + 循环链表
   ![](../image/img2-2-2.jpg) 
   + 双向链表
   ![](../image/img2-2-3.jpg) 

+ 链表实践技巧
    
    + 使用哨兵简化实现难度
    + 建议大家在实现之前的思考时间不要太长。一是先用自己能想到的暴力方法实现试试。另外就是在一定时间内(比如半个到一个小时)实在想不到就要在网上搜搜答案。有的算法，比如链表中环的检测，的最优解法还是挺巧妙的，一般来说不是生想就能想到的
   
**思考**
+ 快慢指针法
+ cpu缓存机制

**实践**
+ 实现链表[代码例子(完成)](/src/main/java/com/zlykernel/pratice/algorithm/link/SinglyLinkedList.java) 
+ 单向链表反转 [代码例子(完成) reverse方法](/src/main/java/com/zlykernel/pratice/algorithm/link/SinglyLinkedList.java) 
+ 链表是否有环 [代码例子(完成) exsitCycleInLinkedList方法 exsitCycleInLinkedList1方法](/src/main/java/com/zlykernel/pratice/algorithm/link/SinglyLinkedList.java) 
+ 求链表的中间结点 [代码例子](../../algorithm/others/README.md)
+ 链表实现 LRU 缓存淘汰算法 [代码例子](../../algorithm/others/README.md) 
+ 判断一个字符串是否是回文字符串 [代码例子](../../algorithm/others/README.md) 
+ 双向链表反转 [代码例子](../../algorithm/others/README.md) 
+ 两个有序的链表合并 [代码例子](../../algorithm/others/README.md)
+ 删除链表倒数第 n 个结点 [代码例子](../../algorithm/others/README.md)
