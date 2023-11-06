package com.example.task_buddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TaskLinkActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_link);
    }
    public void onAddClick(View view){
        Intent intent = new Intent(this, TaskViewDisplay.class);
        startActivity(intent);
    }
}
