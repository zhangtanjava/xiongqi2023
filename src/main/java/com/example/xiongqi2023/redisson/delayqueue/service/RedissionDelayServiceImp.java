package com.example.xiongqi2023.redisson.delayqueue.service;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedissionDelayServiceImp implements RedissionDelayService {
    @Autowired
    RedissonClient redissonClient;
    @Override
    public void produce(String massage) {
        String queuename = "delay-queue";
        RBlockingQueue<String> blockingQueue = redissonClient.getBlockingQueue(queuename);
        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
        delayedQueue.offer(massage, 5, TimeUnit.SECONDS);
    }
}
