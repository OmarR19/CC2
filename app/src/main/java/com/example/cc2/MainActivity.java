package com.example.cc2;

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

    public void Acceder(View view) {
        Intent it = null;
        switch (view.getId()) {
            case R.id.btnAjouter:
                it = new Intent(MainActivity.this, AjouterEntreprise.class);
                break;
            case R.id.btnEditer:
                it = new Intent(MainActivity.this, EditerEntreprise.class);
                break;
            case R.id.btnListe:
                it = new Intent(MainActivity.this, ListeDesEnterprises.class);
                break;

        }
        startActivity(it);
    }
}