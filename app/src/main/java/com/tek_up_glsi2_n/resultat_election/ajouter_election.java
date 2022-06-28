package com.tek_up_glsi2_n.resultat_election;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("ALL")
public class ajouter_election extends AppCompatActivity{
    EditText e1;
    Button btn;
    datahelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_elec);

        //instante db
        db = new datahelper(this);
        //input element
        e1 = findViewById(R.id.nom_elec);
        //submit button
        btn = findViewById(R.id.id_cree_ele);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = e1.getText().toString();
                //check name value
                if (nom.equals("")) {
                    //alert
                    Toast.makeText(getApplicationContext(), "Files are empty", Toast.LENGTH_LONG).show();
                } else {
                    //create election
                    db.insertelection(nom);
                    //rediract to election list
                    Intent i = new Intent(getApplicationContext(), liste_election_admin.class);
                    startActivity(i);
                }
            }
        });
    }

}
