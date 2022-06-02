package com.example.cc2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;
import java.util.ArrayList;



public class EditerEntreprise extends AppCompatActivity {

        Spinner sp;
        EditText elib, efam, epa, epv;
        MyDatabase db;
        ArrayList<Entreprise> etrp;
        ArrayAdapter adptr;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.editerentreprise);

            db = new MyDatabase(this);

            ed11 = findViewById(R.id.ed11);
            ed22 = findViewById(R.id.ed22);
            ed33 = findViewById(R.id.ed33);


            etrp = MyDatabase.getAllEntreprise(db.getReadableDatabase());

            ArrayList<String> nomsProds = new ArrayList<>();
            for(Entreprise ee: etrp)
                nomsProds.add(ee.getId() + " - " + ee.getRaisonSoc());

            adptr = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,nomsProds);
            sp.setAdapter(adptr);

            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Entreprise e = etrp.get(i);

                    ed11.setText(e.getRaisonSoc());
                    ed22.setText(e.getAdresse());
                    ed33.setText(e.getCapital());


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    public void Modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditerEntreprise.this);
        alert.setTitle("Modifier Entreprise");
        alert.setMessage("Voulez-vous modifier l'entreprise ?");


        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Entreprise e = etrp.get(sp.getSelectedItemPosition());

                e.setRaisonSoc(ed11.getText().toString());
                e.setAdresse(ed22.getText().toString());
                e.setCapital(Double.valueOf(ed33.getText().toString()));


                if(MyDatabase.UpdateEntreprise(db.getWritableDatabase(),e);==-1)
                    Toast.makeText(EditerEntreprise.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditerEntreprise.this, "Modification reussie", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditerEntreprise.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
    public void Supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditerEntreprise.this);
        alert.setTitle("Suppression Entreprise");
        alert.setMessage("Voulez-vous supprimer ce l'entreprise ?");
        alert.setIcon(R.drawable.delete);

        alert.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Entreprise e = etrp.get(sp.getSelectedItemPosition());

                if(MyDatabase.UpdateEntreprise(db.getWritableDatabase(),e.getId());==-1)
                Toast.makeText(EditerEntreprise.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                    else {
                    Toast.makeText(EditerEntreprise.this, "Suppression reussie", Toast.LENGTH_SHORT).show();
                    adptr.remove(e.getId() + " - " + e.getRaisonSoc());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditerEntreprise.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}




