package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Bai4_Activity extends AppCompatActivity {
    TextInputEditText textInputEditTextEmail;
    TextInputEditText textInputEditTextPassword;
    Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_bai6);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bai 4 ne");
        }

        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textInputEditTextEmail.getText().toString();
                String password = textInputEditTextPassword.getText().toString();
                if (email.isEmpty()) {
                    textInputEditTextEmail.setError("This is required");
                }

                if (password.isEmpty()) {
                    textInputEditTextPassword.setError("This is required");
                }
            }
        });
    }


}
