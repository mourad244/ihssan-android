package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loginAssociation(View view){
        //show login form
        Intent intent=new Intent(this, AuthAssociation.class);
        startActivity(intent);
    }

    public void toListAssociation(View view){
        Intent intent = new Intent(this,Accueil.class);
        startActivity(intent);

    }
}