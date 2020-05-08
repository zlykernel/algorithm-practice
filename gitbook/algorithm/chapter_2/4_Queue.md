**需求/现实应用**
   
   + 队列在线程池等有有限资源池中的应用
   + Linux环形缓存，使用循环并发队列
   + 高性能队列Disruptor，使用循环并发队列
   + Java concurrent并发包利用ArrayBlockingQueue来实现公平锁
   
**原理/理论**
   + 模型抽象 : 入列(enqueue) 和 出列(dequeue)
   + 类型
   ```
基础队列:
    顺序队列
    链式队列
变种队列:
    循环队列
    阻塞队列
    并发队列
   ``` 
   + 复杂度分析
```
    时间复杂度:
        最好时间复杂度:正常情况入列和出列为O(1)
        最坏时间复杂度:当发生数据搬移时为O(n)
        均摊时间复杂度:为O(n)/n = O(1)

    空间复杂度:
        入列和出列不需要额外空间为O(1)

```

   
**思考/总结/扩展**

   + 总结
```
1.队列使用场景:当资源有限的时候，来实现请求队列化。

2.数组和链表是基础数据结果，其他结构可以基于此两种结构，数组需要考虑扩容问题。

3.无锁化一般使用cas:java中的应用JUC;cas的原理Linux的X86下主要是通过cmpxchgl这个指令在CPU级完成CAS操作的，但在多处理器情况下必须使用lock指令加锁来完成;问题ABA问题，JAVA中提供了AtomicStampedReference/AtomicMarkableReference来处理会发生ABA问题的场景，主要是在对象中额外再增加一个标记来标识对象是否有过变更。

4.实现队列时主要是，双指针的临界判断，影响到扩容及循环队列。
```
   + 思考
```
1.除了线程池这种池结构会用到队列排队请求，你还知道有哪些类似的池结构或者场景中会用到队列的排队请求呢？

答案:分布式消息队列 kafka

2.如何实现无锁并发队列

答案: cas + 数组的方式

```
   + 扩展
```
jdk相关队列
   常见非阻塞队列
      ArrayDeque （数组双端队列）
      PriorityQueue （优先级队列）
      ConcurrentLinkedQueue （基于链表的并发队列）
      PriorityQueue 类实质上维护了一个有序列表。加入到 Queue 中的元素根据它们的天然排序（通过其 java.util.Comparable 实现）或者根据传递给构造函数的 java.util.Comparator 实现来定位。
      ConcurrentLinkedQueue 是基于链接节点的、线程安全的队列。并发访问不需要同步。因为它在队列的尾部添加元素并从头部删除它们，所以只要不需要知道队列的大小，ConcurrentLinkedQueue 对公共集合的共享访问就可以工作得很好。收集关于队列大小的信息会很慢，需要遍历队列。
      回到顶部

   常见阻塞队列BlockingQueue
      ArrayBlockingQueue和LinkedBlockingQueue是两个最普通也是最常用的阻塞队列，一般情况下，在处理多线程间的生产者消费者问题，使用这两个类足以。
      DelayQueue （延期阻塞队列）（阻塞队列实现了BlockingQueue接口）
      ArrayBlockingQueue （基于数组的并发阻塞队列） 底层是数组，有界队列，如果我们要使用生产者-消费者模式，这是非常好的选择。
      LinkedBlockingQueue （基于链表的FIFO阻塞队列）  底层是链表，可以当做无界和有界队列来使用，所以大家不要以为它就是无界队列。
      LinkedBlockingDeque （基于链表的FIFO双端阻塞队列）
      PriorityBlockingQueue （带优先级的无界阻塞队列） 是无界队列，基于数组，数据结构为二叉堆，数组第一个也是树的根节点总是最小值。
      SynchronousQueue （并发同步阻塞队列）本身不带有空间来存储任何元素，使用上可以选择公平模式和非公平模式。
      BlockingQueue 的核心方法：
      BlockingQueue 对插入操作、移除操作、获取元素操作提供了四种不同的方法用于不同的场景中使用：

```



**实践/测试**

+ [顺序队列 扩容 缩容 数据搬移](/src/main/java/com/zlykernel/pratice/algorithm/queue/ArrayQueue.java)
+ [链式队列](/src/main/java/com/zlykernel/pratice/algorithm/queue/LinkedListQueue.java)
+ [循环队列]()
+ [阻塞队列]()
+ [并发队列]()
+ [使用CAS实现无锁队列]()
