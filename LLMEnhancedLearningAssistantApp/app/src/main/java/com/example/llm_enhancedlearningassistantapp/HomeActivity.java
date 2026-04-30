package com.example.llm_enhancedlearningassistantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView helloText = findViewById(R.id.helloText);
        View taskCard = findViewById(R.id.taskCard);

        helloText.setText("Hello,\n" + AppStore.getUsername(this));
        taskCard.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));

        taskCard.setOnClickListener(v -> startActivity(new Intent(this, TaskActivity.class)));
    }
}