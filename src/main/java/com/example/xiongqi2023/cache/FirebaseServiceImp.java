package com.example.xiongqi2023.cache;

import com.example.xiongqi2023.apollo.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FirebaseServiceImp implements FirebaseService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    CachePublishService cachePublishService;

    @Override
    public Result saveUserToken(String userToken) {
        redisTemplate.opsForSet().add(CacheConstant.CACHE_SET, userToken);
        List<String> userTokens = new ArrayList<>();
        userTokens.add(userToken);
        updateLocalCache(userTokens, CacheType.ADD.getType());
        return Result.ok("success");
    }

    /**
     * 通知所有订阅的服务器更新本地缓存
     *
     * @param values
     */
    private void updateLocalCache(List<String> values, int type) {
        CacheMassage cacheMassage = new CacheMassage();
        cacheMassage.setType(type);
        cacheMassage.setValues(values);
        cachePublishService.convertAndPublish(cacheMassage);
    }
}
