package com.example.xiongqi2023;

import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.entity.completions.Completion;
import com.unfbx.chatgpt.sse.ConsoleEventSourceListener;
import org.junit.Before;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * 描述： 测试类
 *
 * @author https:www.unfbx.com
 * 2023-02-28
 */
public class OpenAiStreamClientTest {

    private OpenAiStreamClient client;

    @Before
    public void before() {
        //代理可以不设置
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.111", 7890));
        //推荐这种构造方式
        client = OpenAiStreamClient.builder()
                .connectTimeout(50)
                .readTimeout(50)
                .writeTimeout(50)
                .apiKey("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")
                .proxy(null)
                .apiHost("https://api.openai.com/")
                .build();
    }

    @Test
    public void chatCompletions() {
        ConsoleEventSourceListener eventSourceListener = new ConsoleEventSourceListener();
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Arrays.asList(message)).build();
        client.streamChatCompletion(chatCompletion, eventSourceListener);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void completions() {
        ConsoleEventSourceListener eventSourceListener = new ConsoleEventSourceListener();
        Completion q = Completion.builder()
                .prompt("一句话描述下开心的心情")
                .stream(true)
                .build();
        client.streamCompletions(q, eventSourceListener);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
