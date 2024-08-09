package com.example.xiongqi2023;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableApolloConfig() // 开启后apollo@Value才能生效
public class Xiongqi2023Application {

    public static void main(String[] args) {
        SpringApplication.run(Xiongqi2023Application.class, args);
    }

}
