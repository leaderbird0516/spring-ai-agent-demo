package com.example.aia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiAgentService {

    private final ChatClient chatClient;

    /**
     * 基于Spring AI Agent GPT进行问答
     */
    public String chatWithAi(String userInput) {
        // 基础Prompt模版
        String prompt = "你是一个有帮助的AI助理，请用中文回答以下用户问题：\n\n问题：{question}";
        PromptTemplate promptTemplate = new PromptTemplate(prompt);
        promptTemplate.add("question", userInput);
        // 调用OpenAI大模型
        return chatClient.call(promptTemplate).getResult().getOutput();
    }
}