//IM/2020/062-Shadurceya Vasanthakumar

package com.example.task_buddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {
    private EditText taskNameEditText;
    private EditText taskDescriptionEditText;
    String taskName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        taskNameEditText = findViewById(R.id.taskName);
        taskDescriptionEditText = findViewById(R.id.taskDescription);

        taskName = taskNameEditText.getText().toString().trim();
    }



    public void onSettingClick(View view) {
        String taskName = taskNameEditText.getText().toString().trim();
        String taskDescription = taskDescriptionEditText.getText().toString().trim();

        // Check if task name and description are not empty
        if (taskName.isEmpty() || taskDescription.isEmpty()) {
            Toast.makeText(this, "Please enter both task name and description.", Toast.LENGTH_LONG).show();
            return;
        }

        // Check for word limit in task description
        if (countWords(taskDescription) > 20) {
            Toast.makeText(this, "Task description cannot exceed 20 words.", Toast.LENGTH_LONG).show();
            return;
        }

        // If checks pass, proceed to the next activity
        Intent intent = new Intent(this, TaskSettingActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        SharedPreferences sharedPreferences = getSharedPreferences("TASKS", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("taskName", taskName);
        editor.apply();
    }

    private int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("\\s+");
        return words.length;
    }
}
