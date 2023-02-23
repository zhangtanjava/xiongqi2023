package com.example.xiongqi2023.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class CacheRedisMQConfig {

    private int corePoolSize = 2;
    private int maxPoolSize = 4;
    private int queueCapacity = 1000;
    private int keepAlive = 30;

    private String namePrefix = "userTokensCache-";

    @Bean
    public Executor redisMqAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //除核心线程外的线程存活时间
        executor.setKeepAliveSeconds(keepAlive);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(namePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    /**
     * 消息监听器，使用MessageAdapter可实现自动化解码及方法代理
     *
     * @return
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(UserTokensCacheSubscriber cacheSubscriber) {
        MessageListenerAdapter adapter = new MessageListenerAdapter(cacheSubscriber, "onMessage");
        return adapter;
    }

    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     *
     * @return
     */

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, Executor redisMqAsyncExecutor,
                                                   MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(redisMqAsyncExecutor);
        container.addMessageListener(listenerAdapter, new PatternTopic(CacheConstant.CACHE_TOPIC));
        return container;
    }
}
