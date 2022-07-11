package com.hmh.executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.*;

/**
 * @author Mr.hemenghao
 * @description 线程池demo
 * @date 2022-07-07 16:15
 **/
public class ExecutorPool {
    public static void main(String[] args) {
        //创建固定大小的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        //创建只有一个线程的线程池，确保任务串行执行
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //创建一个不限制线程数的线程池。如果当前线程池的规模超出了处理需求，将回收空的线程；当需求增加时，会增加线程数量；线程池规模无限制。
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建一个固定长度的线程池，而且以延迟或者定时的方式来执行
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(5);

        /*
         * int corePoolSize：核心线程池大小
         * int maximumPoolSize：最大线程池大小
         * long keepAliveTime：线程最大的空闲时间（标记线程空闲多久释放）
         * TimeUnit unit：keepAliveTime的时间单位
         *      SynchronousQueue没有容量，是无缓冲等待队列，是一个不存储元素的阻塞队列，会直接将任务交给消费者，必须等队列中的添加元素被消费后才能继续添加新的元素。
         *      拥有公平（FIFO）和非公平(LIFO)策略，非公平侧罗会导致一些数据永远无法被消费的情况？
         *      LinkedBlockingQueue一个无界缓存等待队列。当前执行的线程数量达到corePoolSize的数量时，剩余的元素会在阻塞队列里等待，当队列满时，才会开启新的线程，立即执行新添加的任务，当线程数达到 maximumPoolSize 数量时，执行线程拒绝策略。每个线程完全独立于其他线程。生产者和消费者使用独立的锁来控制数据的同步，即在高并发的情况下可以并行操作队列中的数据。
         *      ArrayBlockingQueue一个有界缓存等待队列，可以指定缓存队列的大小，当正在执行的线程数等于corePoolSize时，多余的元素缓存在ArrayBlockingQueue队列中等待有空闲的线程时继续执行，当ArrayBlockingQueue已满时，加入ArrayBlockingQueue失败，会开启新的线程去执行，当线程数已经达到最大的maximumPoolSizes时，再有新的元素尝试加入ArrayBlockingQueue时会执行拒绝策略。
         * BlockingQueue wordQueue：阻塞队列
         * ThreadFactory threadFactory：线程的创建工厂，一般不用动
         * RejectedExecutionHandle：拒绝策略
         *      AbortPolicy 直接throw 一个异常，不做处理
         *      CallerRunsPolicy  如果添加线程池失败，就把任务交给主线程去执行。好比排队领妹子，你不让我排队，那我自己去找妹子.
         *      DiscardOldestPolicy  如果阻塞队列满了，就把最开始加入队列的任务移除出去。再尝试加入队列。
         *      DiscardPolicy   不做任何处理，RejectedExecution是一个空方法
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, // 核心线程2
                6, // 最大线程6
                3, // 最大空闲时间3秒
                TimeUnit.SECONDS, // 时间单位秒
                new LinkedBlockingDeque<>(4), // 阻塞队列，容量4
                Executors.defaultThreadFactory(), // 默认的创建工厂
                new ThreadPoolExecutor.AbortPolicy() //AbortPolicy拒绝策略，抛出异常
        );
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 3, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("treasure-chest-%d").build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        //可以看到在for循环中i < 5,没有超过最大线程，此时使用的是 2 个核心线程在执行
        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("正在执行: " + Thread.currentThread().getName());
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
        try {
            for (int i = 0; i < 100; i++) {
                executor.execute(() -> {
                    System.out.println("正在执行: " + Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
