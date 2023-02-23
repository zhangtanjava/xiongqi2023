package com.example.xiongqi2023.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class CachePublicServiceImp implements CachePublishService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private final static String CHANNEL = new ChannelTopic(CacheConstant.CACHE_TOPIC).getTopic();

    @Override
    public void convertAndPublish(CacheMassage cacheMassage) {
        String message = JSON.toJSONString(cacheMassage);
        redisTemplate.convertAndSend(CHANNEL, message);
    }
}
