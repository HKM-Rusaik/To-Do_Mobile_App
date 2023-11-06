//M/2020/084 - SS Ahamed

package com.example.task_buddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileViewActivity extends AppCompatActivity {
    private TextView usernameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);

        // Initialize the TextView using findViewById
        usernameTextView = findViewById(R.id.textView29);

        // Get the username from the Intent that started this Activity
        String username = getIntent().getStringExtra("username");

        // Set the username to the TextView
        usernameTextView.setText(username);
    }
    public void onAddTaskClick(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
