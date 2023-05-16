package com.example.springbootdockerex;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class WebhookController {

    @PostMapping("/send-webhook")
    public String sendWebhook() {
        String webhookUrl = "https://discord.com/api/webhooks/1090549186040184913/_nVKm8TfNkMjjZDz2lgNqbVQBmciLcgii6trO7nXIEz7LAtMHVRBXkSVwoSd-nYRGxzU";

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDateString = currentDate.format(formatter);

        String jsonPayload = String.format("{\"content\": \"Today is %s\", \"name\": \"%s\"}", currentDateString, System.getenv("HOSTNAME"));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(webhookUrl, jsonPayload, String.class);

        return "Webhook sent successfully";
    }
}
