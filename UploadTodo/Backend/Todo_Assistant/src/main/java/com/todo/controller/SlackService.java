package com.todo.controller;


import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class SlackService {

//    @Value("${SLACK_WEBHOOK_URL}")
//    private String slackWebhookUrl;

    public void sendToSlack(String message) throws IOException {
    	final String SLACK_WEBHOOK_URL = "https://hooks.slack.com/services/ActualSlackURL";
        OkHttpClient client = new OkHttpClient();

        JSONObject json = new JSONObject();
        json.put("text", message);

        RequestBody body = RequestBody.create(
                json.toString(),
                MediaType.get("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(SLACK_WEBHOOK_URL)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Slack webhook failed: " + response.body().string());
            }
        }
    }
}
