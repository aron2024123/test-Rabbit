package com.example.aiservice.controller;

import com.example.aiservice.model.AIResponse;
import com.example.aiservice.model.QuestionRequest;
import com.example.aiservice.service.AIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebFluxTest(AIController.class)
public class AIControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AIService aiService;

    @Test
    public void testAskQuestion() {
        // Given
        QuestionRequest request = new QuestionRequest();
        request.setQuestion("What is Spring Boot?");
        
        AIResponse mockResponse = new AIResponse("Spring Boot is a framework for building Java applications.");
        
        when(aiService.getAnswer(anyString())).thenReturn(Mono.just(mockResponse));

        // When & Then
        webTestClient.post()
                .uri("/api/ai/ask")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AIResponse.class)
                .isEqualTo(mockResponse);
    }
} 