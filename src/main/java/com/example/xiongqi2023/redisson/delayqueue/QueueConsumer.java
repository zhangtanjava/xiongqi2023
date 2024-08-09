//package com.example.xiongqi2023.redisson.delayqueue;
//
//import cn.hutool.core.thread.ThreadFactoryBuilder;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RBlockingQueue;
//import org.redisson.api.RDelayedQueue;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.concurrent.*;
//
//
//@Slf4j
//@Component
//public class QueueConsumer {
//
//    public static final String jobsTag = "delay_job";
//    @Autowired(required = false)
//    private RedissonClient redissonClient;
//    @Autowired
//    private static ExecutorService executorService;
//
//
//    @PostConstruct
//    public void startJobTimer() {
//
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("delay-job-service").build();
//        executorService = new ThreadPoolExecutor(1, 2, 30,
//                TimeUnit.MINUTES, new LinkedBlockingQueue<>(30), namedThreadFactory);
//
//        String queuename = "firebase-delay-queue";
//        RBlockingQueue<String> blockingQueue = redissonClient.getBlockingQueue(queuename);
//        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
//        while (true) {
//            try {
//                String msg = blockingQueue.take();
//                System.out.println(msg);
//                executorService.execute(new ExecutorTask(msg));
//            } catch (Exception e) {
//                log.error(e.getMessage());
//            }
//        }
//    }
//
//    class ExecutorTask implements Runnable {
//        String object = "";
//
//        public ExecutorTask(String msg) {
//            object = msg;
//        }
//
//        @SneakyThrows
//        @Override
//        public void run() {
//            // 解析objec然后放入延时队列中
//
//        }
//    }
//
//}
//
