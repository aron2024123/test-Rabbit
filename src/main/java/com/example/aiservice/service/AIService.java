package com.example.aiservice.service;

import com.example.aiservice.model.AIResponse;
import reactor.core.publisher.Mono;

public interface AIService {
    Mono<AIResponse> getAnswer(String question);
} 