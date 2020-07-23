package com.example.personalasisstantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TaskFile extends AppCompatActivity {

    private Button btnLogOut;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_file);

        preferences = getSharedPreferences("APP_MODE",MODE_PRIVATE);
        editor = preferences.edit();

        String userName = preferences.getString(RegisterActivity.KEY_FULL_NAME,"");
        String userEmail = preferences.getString("EMAIL_ADDRESS","");


    }

    public void setBtnLogOut(View view) {
        editor.putBoolean(MainActivity.KEY_LOGGED_IN,false);

        editor.putString("PASSWORD","");
        editor.putString("EMAIL_ADDRESS","");
        editor.apply();


        startActivity(new Intent(TaskFile.this,MainActivity.class));
        finish();

    }
}