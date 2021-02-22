package com.example.lesson2_android_homework;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    Button button_light;
    Button button_night;
    SharedPreferences activityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPreferences = getSharedPreferences("myApp",MODE_PRIVATE);
        if(activityPreferences.contains("themes")) {
            if(activityPreferences.getString("themes", "").equals("light")) {
                setTheme(R.style.Theme_Lesson2_Android_HomeWork);
            } else {
                setTheme(R.style.Theme_Lesson2_Android_HomeWork_Night);
            }
        }
        setContentView(R.layout.activity_settings);

        button_light = findViewById(R.id.button_light);
        button_night = findViewById(R.id.button_night);

        button_light.setOnClickListener(this);
        button_night.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_light) {
            activityPreferences.edit().putString("themes", "light").commit();
            recreate();
        } else {
            activityPreferences.edit().putString("themes", "night").commit();
            recreate();
        }
    }
}