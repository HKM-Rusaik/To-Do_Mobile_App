package com.example.task_buddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TaskViewDisplay extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_view);

        TextView dateTextView = findViewById(R.id.textView39);
        String currentDate = getCurrentDate();
        dateTextView.setText(currentDate);

    }
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault());
        return dateFormat.format(Calendar.getInstance().getTime());
    }
    public void onAddClick(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }
}
