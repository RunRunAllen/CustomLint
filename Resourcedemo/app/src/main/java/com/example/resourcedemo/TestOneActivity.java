package com.example.resourcedemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testlibrary.StatusBarTools;

/**
 *
 */
public class TestOneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv_textview);
        String name = getResources().getClass().getName();
        textView.setText("adfasdf");

        int statusBarHeight = StatusBarTools.getStatusBarHeight(this);

        int identifier = getResources().getIdentifier("tv_textview", "integer", getPackageName());


    }
}
