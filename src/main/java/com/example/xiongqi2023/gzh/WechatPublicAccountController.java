package com.example.xiongqi2023.gzh;


import cn.hutool.crypto.SecureUtil;
import com.example.xiongqi2023.common.model.Result;
import com.example.xiongqi2023.limit.annotation.Limit;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 公众号验证测试类
 * @Author zhangtan
 * @CreateTime 2023/10/11
 */
@Slf4j
@RestController
@RequestMapping("wechat/publicAccount")
public class WechatPublicAccountController {
    // 微信页面填写的token，必须保密
    private static final String TOKEN = "tantantan";

    @GetMapping("validate")
    public String validate(String signature,String timestamp,String nonce,String echostr){
        log.info("接受请求。。。");
        // 1. 将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = {timestamp, nonce, TOKEN};
        Arrays.sort(arr);
        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder sb = new StringBuilder();
        for (String temp : arr) {
            sb.append(temp);
        }
        // 这里利用了hutool的加密工具类
        String sha1 = SecureUtil.sha1(sb.toString());
        // 3. 加密后的字符串与signature对比，如果相同则该请求来源于微信，原样返回echostr
        if (sha1.equals(signature)){
            log.info("返回成功。。。");
            return echostr;
        }
        // 接入失败
        return null;
    }
}

