package com.example.xiongqi2023.redisson.delayqueue.controller;

import com.example.xiongqi2023.apollo.model.Result;
import com.example.xiongqi2023.redisson.delayqueue.service.RedissionDelayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/delayQueue")
@Slf4j
public class RedissonDelayController {
    @Autowired
    RedissionDelayService redissionDelayService;

    @PostMapping(value = "/send")
    public Result<?> send(@RequestParam(name = "massage") String massage) {
        redissionDelayService.produce(massage);
        return Result.ok(massage);
    }

}
