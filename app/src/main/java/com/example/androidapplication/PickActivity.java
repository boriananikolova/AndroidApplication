package com.example.androidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class PickActivity extends AppCompatActivity {

    private Button singleplayer;
    private Button multiplayer;
    private Button logOutBtn;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);

        singleplayer = (Button)findViewById(R.id.single);
        multiplayer = (Button)findViewById(R.id.multi);
        logOutBtn = (Button)findViewById(R.id.logoutBtn);
        firebaseAuth = FirebaseAuth.getInstance();

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(PickActivity.this, MainActivity.class));
            }
        });

        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PickActivity.this, SingleActivity.class));
            }
        });

        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PickActivity.this, GameActivity.class));
            }
        });
    }
}
