package com.knowyou.knowyouaiagent.demo.invoke;

import cn.hutool.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

//@Component
public class HttpAiInvoke implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // 服务器地址
        String url = "http://172.16.1.178:8032/v1/chat/completions";

        // 创建请求体JSON对象
        JSONObject requestBody = new JSONObject();
        requestBody.set("model", "/data/AntiFraudComplaintAnalysis/models/base_models/Qwen/Qwen2___5-32B-Instruct-AWQ");

        // 创建消息列表
        List<JSONObject> messages = new ArrayList<>();

        // 系统消息
        JSONObject systemMessage = new JSONObject();
        systemMessage.set("role", "system");
        systemMessage.set("content", "你是电信运营商的反诈处理助手。");
        messages.add(systemMessage);

        // 用户消息
        JSONObject userMessage = new JSONObject();
        userMessage.set("role", "user");
        userMessage.set("content", "请对运营商目前的反诈工作提一些建议。");
        messages.add(userMessage);

        // 添加消息到请求体
        requestBody.set("messages", messages);

        // 设置模型参数
        requestBody.set("temperature", 0.1);
        requestBody.set("top_p", 0.8);
        requestBody.set("repetition_penalty", 1.05);
        requestBody.set("max_tokens", 512);
        requestBody.set("seed", 42);

        // 转换为JSON字符串
        String json = requestBody.toString();
        System.out.println("请求体JSON: " + json);

        // 创建HttpClient实例
        HttpClient client = HttpClient.newHttpClient();

        // 构建HttpRequest请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // 发送请求并获取响应
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 输出响应结果
        System.out.println("响应状态码: " + response.statusCode());
        System.out.println("响应内容: " + response.body());
    }
}