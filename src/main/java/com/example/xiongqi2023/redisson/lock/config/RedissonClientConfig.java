package com.example.xiongqi2023.redisson.lock.config;

import com.example.xiongqi2023.redisson.lock.constant.Constants;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.URI;
import java.util.Map;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedissonClientConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedissonClientConfig.class);

    @Value("${redis.servers.coop}")
    private String redisServers;

    /**
     * 这里用activity的redis集成redisson
     *
     * @return
     */
    @Bean
    public RedissonClient redissonClient() {

        Config config = new Config();
        URI uri = URI.create(redisServers);
        String query = uri.getQuery();
        Map<String, String> params = parseQuery(query);
        String servers = uri.getAuthority();
        int index = 0;
        for (String server : servers.split(Constants.COMMA)) {
            server = server.startsWith("redis://") ? server : "redis://" + server;
            if (index == 0) {
                config.useSingleServer().setAddress(server);
            }
            index++;

        }
        config.useSingleServer().setPassword(params.get("password"));
        return Redisson.create(config);

    }

    public static Map<String, String> parseQuery(String query) {
        if (StringUtils.isEmpty(query)) {
            return Maps.newHashMap();
        }
        Map<String, String> params = Maps.newHashMap();
        for (String param : query.split(Constants.AMPERSAND)) {
            String[] tuple = param.split(Constants.EQUALITY);
            params.put(tuple[0], tuple[1]);
        }
        return params;
    }


}
