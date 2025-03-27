package com.example.aiservice.controller;

import com.example.aiservice.model.AIResponse;
import com.example.aiservice.model.QuestionRequest;
import com.example.aiservice.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    @Autowired
    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/ask")
    public Mono<AIResponse> askQuestion(@RequestBody QuestionRequest request) {
        if(request.getQuestion() == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
        return aiService.getAnswer(request.getQuestion());
    }
} 