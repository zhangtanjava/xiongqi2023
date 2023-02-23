package com.example.xiongqi2023.redisson.lock.controller;

import com.example.xiongqi2023.apollo.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;
@Slf4j
@RestController
@RequestMapping("/redisson")
public class RedissonLockController {
    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/lock")
    public Result<?> redis() {
        // 分布式锁
        String lockKey = "redissonTest";
        RLock lock = redissonClient.getLock(lockKey);
        try {
            boolean isLock = lock.tryLock(5L, 15L, TimeUnit.SECONDS);
            if (!isLock) {
                return Result.error("获取redis锁失败");
            }

        } catch (Exception e) {
            log.info("异常:",e);

        } finally {
            //判断当前线程是否持有锁 释放锁
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                log.info("lockKey:"+lockKey+"删除成功");
                lock.unlock();
            }
        }
        return Result.ok("获取成功");
    }


}
