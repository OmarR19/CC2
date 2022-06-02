package com.example.cc2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    public void Enregistrer(View view) {

        if(ed1.getText().toString().isEmpty()){
            Toast.makeText(this, "Raison Sociale vide", Toast.LENGTH_SHORT).show();
            ed1.requestFocus();
            return;
        }
        if(ed2.getText().toString().isEmpty()){
            Toast.makeText(this, "Adresse vide", Toast.LENGTH_SHORT).show();
            ed2.requestFocus();
            return;
        }
        if(ed3.getText().toString().isEmpty()){
            Toast.makeText(this, "Capitale vide", Toast.LENGTH_SHORT).show();
            ed3.requestFocus();
            return;
        }

        Entreprise e = new Entreprise();

        e.setRaisonSoc(ed1.getText().toString());
        e.setAdresse(ed2.getText().toString());
        e.setCapital(Double.parseDouble(ed3.getText().toString());
        //Le code de question Enregister problème dans ==-1;
        //if(MyDatabase.AddEntreprise(db.getWritableDatabase(),e);==-1)
          //  Toast.makeText(this, "Enregistrement echoue", Toast.LENGTH_SHORT).show();
        //else
          //  Toast.makeText(this, "Enregistrement reussie", Toast.LENGTH_SHORT).show();


    }
}
