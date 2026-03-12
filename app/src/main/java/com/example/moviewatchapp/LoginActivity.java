package com.example.moviewatchapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etLoginEmail, etLoginPassword;
    Button btnLogin;
    TextView txtGoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtGoRegister = findViewById(R.id.txtGoRegister);

        btnLogin.setOnClickListener(v -> {
            String email = etLoginEmail.getText().toString().trim();
            String password = etLoginPassword.getText().toString().trim();

            SharedPreferences prefs = getSharedPreferences("MovieWatchApp", MODE_PRIVATE);
            String savedEmail = prefs.getString("userEmail", "");
            String savedPassword = prefs.getString("userPassword", "");

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else if (email.equals(savedEmail) && password.equals(savedPassword)) {
                prefs.edit().putBoolean("isLoggedIn", true).apply();
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Invalid login details", Toast.LENGTH_SHORT).show();
            }
        });

        txtGoRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}