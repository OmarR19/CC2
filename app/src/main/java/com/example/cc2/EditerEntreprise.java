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
            ed22 = findViewById(R.id.editfam);
            epa = findViewById(R.id.editpa);
            epv = findViewById(R.id.editpv);

            prds = MyDBProduit.getAllprods(db.getReadableDatabase());

            ArrayList<String> nomsProds = new ArrayList<>();
            for(Produit pp: prds)
                nomsProds.add(pp.getId() + " - " + pp.getLibelle());

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


}
