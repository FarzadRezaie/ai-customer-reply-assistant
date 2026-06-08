package com.farzad.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Map;


@Service
public  class ReplyService{

@Value("${gemini.api.key}")
private String apiKey;

private final  WebClient webClient = WebClient.builder()
        .baseUrl("https://generativelanguage.googleapis.com/v1beta")
        .build();


public String generateReply(String customerMessage){
    Map<String, Object> requestBody = Map.of(
        "contents" , new Object[]{
            Map.of("parts", new Object[]{
               Map.of("text", "You are a customer service agent. Write ONE short, polite, professional reply to the following customer message. Do not give options or explanations, just the reply itself: " + customerMessage)
        })
    }
);

    Map response = webClient.post()
        .uri("/models/gemini-2.5-flash:generateContent?key=" + apiKey)
        .header("Content-Type", "application/json")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Map.class)
        .block();

        Map candidate = ((java.util.List<Map>) response.get("candidates")).get(0);
        Map content = (Map) candidate.get("content");
        java.util.List<Map> parts = (java.util.List<Map>) content.get("parts");
        String reply = (String) parts.get(0).get("text");

        return reply;
}

public  String testKey(){
    boolean loaded  = (apiKey != null && !apiKey.isEmpty());
    return "Key loaded : " + loaded;
}



}