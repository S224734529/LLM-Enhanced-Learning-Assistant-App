package com.example.llm_enhancedlearningassistantapp;

import android.os.Handler;
import android.os.Looper;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LlmRepository {
    public interface LlmCallback {
        void onSuccess(String text);
        void onFailure(String error);
    }

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static final String BACKEND_URL = "https://your-backend-url.com/llm";

    private final OkHttpClient client = new OkHttpClient();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public void generate(String prompt, LlmCallback callback) {
        if (BACKEND_URL.contains("your-backend-url")) {
            simulate(prompt, callback);
            return;
        }

        try {
            JSONObject body = new JSONObject();
            body.put("prompt", prompt);

            Request request = new Request.Builder()
                    .url(BACKEND_URL)
                    .post(RequestBody.create(body.toString(), JSON))
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    mainHandler.post(() -> callback.onFailure("API failure: " + e.getMessage()));
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        mainHandler.post(() -> callback.onFailure("API returned status " + response.code()));
                        return;
                    }

                    String raw = response.body() != null ? response.body().string() : "";
                    try {
                        JSONObject object = new JSONObject(raw);
                        String text = object.optString("response", raw);
                        mainHandler.post(() -> callback.onSuccess(text));
                    } catch (Exception ex) {
                        mainHandler.post(() -> callback.onSuccess(raw));
                    }
                }
            });
        } catch (Exception ex) {
            callback.onFailure("Request error: " + ex.getMessage());
        }
    }

    private void simulate(String prompt, LlmCallback callback) {
        mainHandler.postDelayed(() -> {
            String lower = prompt.toLowerCase();

            if (lower.contains("hint")) {
                callback.onSuccess("Hint: Break the problem into smaller steps. First identify the key concept, then remove answers that do not match it.");
            } else if (lower.contains("flashcard")) {
                callback.onSuccess("Flashcard 1: What is an algorithm? A clear set of steps to solve a problem.\n\nFlashcard 2: What is testing? Checking that software behaves as expected.\n\nFlashcard 3: What is data structure? A way to organise data for efficient use.");
            } else {
                callback.onSuccess("This answer is partly correct. The main idea is clear, but it needs a stronger link to the topic and one example.");
            }
        }, 900);
    }
}