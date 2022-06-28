package com.tek_up_glsi2_n.resultat_election;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("ALL")
public class ajouter_choix extends AppCompatActivity{
    EditText e1;
    Button btn;
    datahelper db;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_choix);

        //instante db
        db = new datahelper(this);
        //input element
        e1 = findViewById(R.id.nom_choix);
        //submit button
        btn = findViewById(R.id.id_cree_choix);
        in = getIntent();
        //get election id
        final int id = Integer.parseInt(Objects.requireNonNull(in.getStringExtra("id")));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = e1.getText().toString();
                //check choice value
                if (nom.equals("")) {
                    //alert
                    Toast.makeText(getApplicationContext(), "Empty value", Toast.LENGTH_LONG).show();
                } else {
                    //add choice to list
                    db.insertchoix(nom, id);
                    //rediract to election choice list
                    Intent i = new Intent(getApplicationContext(), list_choix_admin.class);
                    i.putExtra("id", String.valueOf(id));
                    startActivity(i);
                }
            }
        });
    }
}