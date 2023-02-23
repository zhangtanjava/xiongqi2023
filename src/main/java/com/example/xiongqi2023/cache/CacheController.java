package com.example.xiongqi2023.cache;

import com.example.xiongqi2023.apollo.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController {

    @Autowired
    FirebaseService firebaseService;
    @Autowired
    CachePublishService cachePublishService;

    @PostMapping(value = "/upload/userToken")
    public Result<?> uploadUserToken(@RequestParam(name = "userToken") String userToken) {
        return firebaseService.saveUserToken(userToken);
    }

    /**
     * 发布请求到redis channel，等待订阅者获取消费
     *
     * @return
     */
    @RequestMapping("/publish")
    public Result<?> test(@RequestBody CacheMassage cacheMassage) {
        cachePublishService.convertAndPublish(cacheMassage);
        return Result.ok();
    }

}
