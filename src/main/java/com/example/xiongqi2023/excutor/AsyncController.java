package com.example.xiongqi2023.excutor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * SpringBoot线程池的使用
 * 链接：http://events.jianshu.io/p/5bdfda863e43
 */
@RestController
@RequestMapping("/excutor")
@Slf4j
public class AsyncController{

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async(){
        asyncService.executeAsync();
    }

}