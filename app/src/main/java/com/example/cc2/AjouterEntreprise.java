package com.example.cc2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AjouterEntreprise extends AppCompatActivity {

    EditText ed1, ed2, ed3;
    Button btnaa, btnbb;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouterentreprise);

        db = new MyDatabase(this);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);


    }

    public void Annuler(View view){
        Intent it=new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
