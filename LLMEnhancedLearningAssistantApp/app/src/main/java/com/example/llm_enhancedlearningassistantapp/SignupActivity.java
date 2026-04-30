package com.example.llm_enhancedlearningassistantapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText username = findViewById(R.id.newUsernameInput);
        EditText email = findViewById(R.id.emailInput);
        EditText confirmEmail = findViewById(R.id.confirmEmailInput);
        EditText password = findViewById(R.id.newPasswordInput);
        EditText confirmPassword = findViewById(R.id.confirmPasswordInput);
        Button createButton = findViewById(R.id.createAccountButton);

        createButton.setOnClickListener(v -> {
            String name = username.getText().toString().trim();
            String mail = email.getText().toString().trim();
            String mail2 = confirmEmail.getText().toString().trim();
            String pass = password.getText().toString().trim();
            String pass2 = confirmPassword.getText().toString().trim();

            if (name.isEmpty() || mail.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Complete all required fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!mail.equals(mail2)) {
                Toast.makeText(this, "Email addresses do not match.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(pass2)) {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                return;
            }

            AppStore.saveUser(this, name, mail, pass);
            startActivity(new Intent(this, InterestsActivity.class));
            finish();
        });
    }
}