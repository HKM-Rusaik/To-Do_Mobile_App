package com.example.task_buddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in); // Set the layout XML for the sign-in screen

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        sharedPreferences = getSharedPreferences("user_credentials", MODE_PRIVATE);

        Button signInButton = findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }
    public void onSignUpClick(View view) {
        // Create an Intent to start SignUpActivity
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    private void signIn() {
        // Get user input
        String enteredUsername = usernameEditText.getText().toString().trim();
        String enteredPassword = passwordEditText.getText().toString().trim();

        // Retrieve the stored username and password from SharedPreferences
        String storedUsername = sharedPreferences.getString("username", null);
        String storedPassword = sharedPreferences.getString("password", null);


        // Compare entered username and password with stored credentials
        if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
            // Sign-in successful
            // Proceed with your app's main functionality or navigate to the main screen
            showToast("Sign-in successful!");
            Intent intent = new Intent(SignInActivity.this, ProfileViewActivity.class);
            intent.putExtra("username", enteredUsername);
            startActivity(intent);
        } else {
            // Invalid username or password
            showToast("Invalid username or password. Please try again.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
