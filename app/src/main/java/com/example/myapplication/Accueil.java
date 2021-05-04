package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Accueil extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_accueil);
    }

    public void listeAssociations(View view) {
        Intent intent = new Intent(this, Associations.class);
        startActivity(intent);
    }

    public void listBiens(View view) {
        Intent intent = new Intent(this, Biens.class);
        startActivity(intent);
    }
}
