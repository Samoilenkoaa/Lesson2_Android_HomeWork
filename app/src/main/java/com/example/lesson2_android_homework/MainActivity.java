package com.example.lesson2_android_homework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculator calculator;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button button_C;
    private Button button_rovno;
    private Button button_del;
    private Button button_multiply;
    private Button button_minus;
    private Button button_plus;
    private TextView textView;

    SharedPreferences activityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPreferences = getSharedPreferences("myApp", MODE_PRIVATE);
        if (activityPreferences.contains("themes")) {
            if (activityPreferences.getString("themes", "").equals("light")) {
                setTheme(R.style.Theme_Lesson2_Android_HomeWork);
            } else {
                setTheme(R.style.Theme_Lesson2_Android_HomeWork_Night);
            }
        }
        setContentView(R.layout.activity_main);
        initButtons();
        calculator = new Calculator();
        refreshScreens();
        ButtonsSetOnClickLisner();

    }

    public void refreshScreens() {
        textView.setText(calculator.mainNumber);
    }


    public void initButtons() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);

        button_C = findViewById(R.id.button_C);
        button_rovno = findViewById(R.id.button_equally);
        button_del = findViewById(R.id.button_split);
        button_multiply = findViewById(R.id.button_multiply);
        button_minus = findViewById(R.id.button_minus);
        button_plus = findViewById(R.id.button_plus);
        textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        calculator.input(((Button) v).getText().toString());
        refreshScreens();
    }

    public void ButtonsSetOnClickLisner() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        button_C.setOnClickListener(this);
        button_rovno.setOnClickListener(this);
        button_del.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_plus.setOnClickListener(this);

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putString("keyNumber", calculator.mainNumber);
        instanceState.putString("keyConteiner", calculator.conteiner);
        instanceState.putString("keyOperator", calculator.operator);
        instanceState.putBoolean("startOperation", calculator.startOperation);
        instanceState.putBoolean("startOperationSin", calculator.startOperationSin);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator.mainNumber = savedInstanceState.getString("keyNumber");
        calculator.conteiner = savedInstanceState.getString("keyConteiner");
        calculator.operator = savedInstanceState.getString("keyOperator");
        calculator.startOperation = savedInstanceState.getBoolean("startOperation");
        calculator.startOperationSin = savedInstanceState.getBoolean("startOperationSin");
        refreshScreens();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("settings");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("settings")) {
            Intent intent = new Intent(this, Settings.class);
            startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recreate();
    }
}