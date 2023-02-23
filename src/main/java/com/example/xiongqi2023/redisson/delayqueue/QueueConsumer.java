package com.example.xiongqi2023.redisson.delayqueue;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;


@Slf4j
@Component
public class QueueConsumer {

    public static final String jobsTag = "delay_job";
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private static ExecutorService executorService;



    @PostConstruct
    public void startJobTimer() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("delay-job-service").build();
        executorService = new ThreadPoolExecutor(1, 10, 30,
                TimeUnit.MINUTES, new LinkedBlockingQueue<>(10), namedThreadFactory);

        executorService.execute(new ExecutorTask());
    }

    class ExecutorTask implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            String queuename = "delay-queue";
            RBlockingQueue<String> blockingQueue = redissonClient.getBlockingQueue(queuename);
            RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
//            String msg = blockingQueue.take();
//            RBlockingQueue blockingQueue = client.getBlockingQueue(jobsTag);
            while (true) {
                try {
//                    DelayJobEntity job = (DelayJobEntity) blockingQueue.take();
                    String msg = blockingQueue.take();
                    System.out.println(msg);
                    // 执行逻辑
//                    ExecuteJob service = (ExecuteJob) context.getBean(job.getAClass());
//                    service.execute(job);
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                // 防止疯狂打印日志
                TimeUnit.SECONDS.sleep(10);
            }
        }
    }

}

