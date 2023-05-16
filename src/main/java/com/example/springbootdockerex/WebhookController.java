package com.example.springbootdockerex;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebhookController {

    @RequestMapping(value = { "/send-webhook", "/send-webhook/" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String sendWebhook() {
        String webhookUrl = "https://discord.com/api/webhooks/1090549186040184913/_nVKm8TfNkMjjZDz2lgNqbVQBmciLcgii6trO7nXIEz7LAtMHVRBXkSVwoSd-nYRGxzU";
        String message = "Hello, world!";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String jsonPayload = "{\"content\": \"" + message + "\"}";

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayload, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(webhookUrl, HttpMethod.POST, requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return "Webhook sent successfully";
        } else {
            return "Failed to send webhook. Response code: " + responseEntity.getStatusCodeValue();
        }
    }
}