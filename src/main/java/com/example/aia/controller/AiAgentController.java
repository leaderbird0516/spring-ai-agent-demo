package com.example.aia.controller;

import com.example.aia.service.AiAgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
@RequiredArgsConstructor
public class AiAgentController {

    private final AiAgentService aiAgentService;

    @PostMapping("/chat")
    public String chat(@RequestParam("question") String question) {
        return aiAgentService.chatWithAi(question);
    }
}
