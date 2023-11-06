//IM/2020/058 - Yuvitha Thavarasa

package com.example.task_buddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TaskViewDisplay extends AppCompatActivity {
    private TextView taskNameTextView;
    private DrawerLayout drawerLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_view);

        TextView dateTextView = findViewById(R.id.textView39);
        String currentDate = getCurrentDate();
        dateTextView.setText(currentDate);

        taskNameTextView = findViewById(R.id.taskNameTextView); // Make sure this ID matches your TextView ID in task_view.xml
        SharedPreferences sharedPreferences = getSharedPreferences("TASKS", MODE_PRIVATE);
        String taskName = sharedPreferences.getString("taskName", ""); // Default to empty string if no task name was found
        taskNameTextView.setText(taskName);


        drawerLayout = findViewById(R.id.drawer_layout);

        // Set up the navigation view (drawer)
        NavigationView navigationView = findViewById(R.id.nav_view);
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(navigationView);
            }
        });


    }
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault());
        return dateFormat.format(Calendar.getInstance().getTime());
    }
    public void onAddClick(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
