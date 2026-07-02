package com.nikhil.nickai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.nikhil.nickai.dto.GroqMessage;
import com.nikhil.nickai.dto.GroqRequest;
import com.nikhil.nickai.dto.GroqResponse;

@Service
public class GroqService {

    @Value("${groq.api.url}")
    private String apiUrl;

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.model}")
    private String model;

    private final RestClient restClient;

    public GroqService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String askAI(List<GroqMessage> messages) {

        GroqRequest request = new GroqRequest(model, messages);

        GroqResponse response = restClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(GroqResponse.class);

        if (response == null ||
                response.getChoices() == null ||
                response.getChoices().isEmpty()) {

            return "No response from Groq.";
        }

        return response.getChoices()
                .get(0)
                .getMessage()
                .getContent();
    }

}