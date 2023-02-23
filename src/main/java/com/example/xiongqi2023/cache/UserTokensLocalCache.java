package com.example.xiongqi2023.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class UserTokensLocalCache {

    @Autowired
    private StringRedisTemplate redisTemplate;
    private final static Set<String> userTokensCache = Collections.newSetFromMap(new ConcurrentHashMap<>());

    @PostConstruct
    public void initCache() {
        log.info("initCache start...");
        long startTime = System.currentTimeMillis();
        Set<String> tokens = redisTemplate.opsForSet().members(CacheConstant.CACHE_SET);
        userTokensCache.addAll(tokens);
        log.info("initCache end,tokens counts:" + tokens.size() + "耗时:" + (System.currentTimeMillis() - startTime) + "ms");
    }

    public boolean add(String value) {
        return userTokensCache.add(value);
    }

    public boolean addAll(Collection<String> c) {
        return userTokensCache.addAll(c);
    }

    public boolean removeAll(Collection<String> c) {
        return userTokensCache.removeAll(c);
    }

    public static Set<String> getCache() {
        return userTokensCache;
    }

}
