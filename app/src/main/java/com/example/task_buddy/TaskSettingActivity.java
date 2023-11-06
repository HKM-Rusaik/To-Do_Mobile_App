package com.example.task_buddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task_buddy.AddTaskActivity;
import com.example.task_buddy.R;

public class TaskSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_setting);
    }

    public void onCreateClick(View view){
        Intent intent = new Intent(this, TaskLinkActivity.class);
        startActivity(intent);
    }
}
