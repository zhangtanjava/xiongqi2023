package com.example.xiongqi2023.limit.controller;


import com.example.xiongqi2023.common.model.JResult;
import com.example.xiongqi2023.common.model.Result;
import com.example.xiongqi2023.limit.annotation.Limit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 限流测试类
 * @Author zhangtan
 * @CreateTime 2022/12/22
 */
@RestController
@RequestMapping("/limit")
public class LimitController {
    private static Logger logger = LoggerFactory.getLogger(LimitController.class);

    /**
     * 查询是否上祝福墙
     *
     * @param
     * @return
     */
    @RequestMapping("/test")
    @Limit(key = "isOnBlessingWall", permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "系统繁忙，请稍后再试！")
    public Result isOnBlessingWall(HttpServletRequest request) {
        Result res = Result.SUCCESS(true, "0", "success");
        return res;
    }

}
