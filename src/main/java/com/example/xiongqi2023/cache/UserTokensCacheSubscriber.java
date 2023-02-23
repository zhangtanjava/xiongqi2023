package com.example.xiongqi2023.cache;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 订阅者-消费处理业务逻辑
 *
 */
@Component
public class UserTokensCacheSubscriber {
    private static final Logger logger = LoggerFactory.getLogger(UserTokensCacheSubscriber.class);

    @Autowired
    UserTokensLocalCache userTokensLocalCache;

    public void onMessage(String message, String pattern) {

        logger.info("redisCache订阅请求参数:{}", message);
        try {
            CacheMassage cacheMassage = JSONObject.parseObject(message, CacheMassage.class);
            if (CacheType.ADD.getType() == cacheMassage.getType()){
                userTokensLocalCache.addAll(cacheMassage.getValues());
            }
            if (CacheType.DELETE.getType() == cacheMassage.getType()){
                userTokensLocalCache.removeAll(cacheMassage.getValues());
            }
            logger.info("subscriber成功：{}", cacheMassage);
        } catch (Exception e) {
            logger.error("subscriber失败", e);
        }
    }
}