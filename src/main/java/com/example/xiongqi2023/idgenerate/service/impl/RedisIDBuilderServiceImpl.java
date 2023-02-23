package com.example.xiongqi2023.idgenerate.service.impl;

import com.example.xiongqi2023.idgenerate.service.RedisIDBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service
public class RedisIDBuilderServiceImpl implements RedisIDBuilderService {

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 开始时间戳，参考方法getTimesMap() 2023-01-03 18:17:10
     */
    private static final long BEGIN_TIMESTAMP = 1672741030L;
    /**
     * 序列号的位数
     */
    private static final int COUNT_BITS = 32;
    /**
     * 自增前缀
     */
    private String keyPrefix = "blessing";
    /**
     * long总共64位
     * 高位为0固定
     * 时间戳timestamp占用31位
     * 自增序列号为32位，最大支持每秒产生2^32个序列号（本例以天为单位递增，平均每秒大约49710个）
     **/
    @Override
    public Long nextId() {
        // 1.生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);// LocalTime转换为自1970-01-01T00：00：00Z以来的秒数
        long timestamp = nowSecond - BEGIN_TIMESTAMP;

        // 2.生成序列号
        // 2.1.获取当前日期，精确到天
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        // 2.2.自增长
        long count =redisTemplate.opsForValue().increment("ID:" + keyPrefix + ":" + date);
        // 3.拼接
        long id = timestamp << COUNT_BITS | count;
        return id;
    }

}
