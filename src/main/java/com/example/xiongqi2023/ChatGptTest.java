package com.example.xiongqi2023;
import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import okhttp3.logging.HttpLoggingInterceptor;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
public class ChatGptTest {
    public static void main(String[] args) {
        //配置api keys
        //代理可以为null
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.111", 7890));
        //日志输出可以不添加
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OpenAiClient openAiClient = OpenAiClient.builder()
                .apiKey("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")
                .connectTimeout(50)
                .writeTimeout(50)
                .readTimeout(50)
                .interceptor(Arrays.asList(httpLoggingInterceptor))
                .proxy(null)
                .apiHost("https://api.openai.com/")
                .build();
        CompletionResponse completions = openAiClient.completions("写一篇300字的文章介绍清明节的起源");
        Arrays.stream(completions.getChoices()).forEach(System.out::println);
    }
}
