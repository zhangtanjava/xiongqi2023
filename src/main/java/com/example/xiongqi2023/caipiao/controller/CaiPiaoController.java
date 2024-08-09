package com.example.xiongqi2023.caipiao.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.example.xiongqi2023.apollo.model.Result;
import com.example.xiongqi2023.caipiao.service.CaipiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caipiao")
public class CaiPiaoController {

    @Autowired
    private CaipiaoService caipiaoService;

    @GetMapping("/readAndSava")
    public Result<?> readAndSava(String fileName) {
        caipiaoService.readCvsAndSave(fileName);
        return Result.ok(String.format("success!"));
    }
}
