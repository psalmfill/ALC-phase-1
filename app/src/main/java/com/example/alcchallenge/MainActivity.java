package com.example.alcchallenge;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button aboutAlc = findViewById(R.id.about_alc);
        Button myProfile = findViewById(R.id.my_profile);
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyProfileActivity();
            }
        });

        aboutAlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlcActivity();
            }
        });

    }

    private void startAlcActivity(){
        startNewActivity(AlcActivity.class);
    }

    private void startMyProfileActivity(){
        startNewActivity(ProfileActivity.class);
    }

    private void startNewActivity(Class activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }
}
