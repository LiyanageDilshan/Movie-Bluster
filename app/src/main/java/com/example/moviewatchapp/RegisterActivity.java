package com.example.moviewatchapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etRegisterEmail, etRegisterPassword, etConfirmPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegisterEmail = findViewById(R.id.etRegisterEmail);
        etRegisterPassword = findViewById(R.id.etRegisterPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {

            String email = etRegisterEmail.getText().toString().trim();
            String password = etRegisterPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();

            } else if (!password.equals(confirmPassword)) {

                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();

            } else {

                SharedPreferences prefs = getSharedPreferences("MovieWatchApp", MODE_PRIVATE);

                prefs.edit()
                        .putString("userEmail", email)
                        .putString("userPassword", password)
                        .apply();

                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}