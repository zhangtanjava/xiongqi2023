//package com.example.xiongqi2023.apollo.config;
//
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.ConfigChangeListener;
//import com.ctrip.framework.apollo.model.ConfigChange;
//import com.ctrip.framework.apollo.model.ConfigChangeEvent;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class apolloConfig {
//    @ApolloConfig
//    Config config;
//    /**
//     * @Description:监听配置变化.当配置发生变更，会执行onChange中的逻辑
//     **/
//    @Bean
//    public void initListener(){
//        config.addChangeListener(new ConfigChangeListener() {
//            @Override
//            public void onChange(ConfigChangeEvent changeEvent) {
//                for (String key : changeEvent.changedKeys()) {
//                    ConfigChange change = changeEvent.getChange(key);
//                    System.out.println(String.format(
//                            "Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s",
//                            change.getPropertyName(), change.getOldValue(),
//                            change.getNewValue(), change.getChangeType()));
//                }
//            }
//        });
//    }
//
//
//}
