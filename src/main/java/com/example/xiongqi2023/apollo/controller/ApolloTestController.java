//package com.example.xiongqi2023.apollo.controller;
//
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
//import com.example.xiongqi2023.apollo.model.Result;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/apollo")
//public class ApolloTestController {
//    @Value("${test.name}")
//    private String name;
//
//    @ApolloConfig
//    private Config config;
//
//    @GetMapping("/hello")
//    public Result<?> hello() {
//
//        return Result.ok(String.format("Hello %s!", name));
//    }
//
//    @GetMapping("/helloWorld")
//    public Result<?> helloWorld() {
//        return Result.ok(String.format("Hello %s!", config.getProperty("test.name","默认值啊")));
//    }
//}
