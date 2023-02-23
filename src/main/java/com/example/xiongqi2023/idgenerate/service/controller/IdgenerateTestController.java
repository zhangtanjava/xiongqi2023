package com.example.xiongqi2023.idgenerate.service.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.example.xiongqi2023.apollo.model.Result;
import com.example.xiongqi2023.idgenerate.service.RedisIDBuilderService;
import com.example.xiongqi2023.idgenerate.service.SnowFlakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idgenerate")
public class IdgenerateTestController {
    @Autowired
    RedisIDBuilderService redisIDBuilderService;
    @Autowired
    SnowFlakeService snowFlakeService;

    @GetMapping("/redis")
    public Result<?> redis() {

        return Result.ok(String.format("nextId %s", redisIDBuilderService.nextId()));
    }

    @GetMapping("/snowFlake")
    public Result<?> snowFlake() {

        return Result.ok(String.format("nextId %s", snowFlakeService.nextId()));
    }
}
