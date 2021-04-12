package com.example.map_cadastrelushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class Visualier_liste extends AppCompatActivity {
    FloatingActionButton carte;
    ListView listeReq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualier_liste);
        listeReq = findViewById(R.id.listeRequerant);
        carte = findViewById(R.id.floatingActionButton);
        carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Visualier_liste.this, MapView.class);
                startActivity(i);
            }
        });

        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;

        map = new HashMap<String, String>();
        map.put("identite", "Mwenge Mwanangongo heritier");
        map.put("detail", "001");
        map.put("img", String.valueOf(R.drawable.ic_email));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("identite", "delavie eternelle");
        map.put("detail", "003");
        map.put("img", String.valueOf(R.drawable.img));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("identite", "yemba mahuya");
        map.put("numero", "123");
        map.put("img", String.valueOf(R.drawable.img));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("identite", "Arsene lumbu");
        map.put("numero", "456");
        map.put("img", String.valueOf(R.drawable.ic_email));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("identite", "Chancelle chancy");
        map.put("numero", "567");
        map.put("img", String.valueOf(R.drawable.img));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("identite", "Heritier delavie");
        map.put("numero", "768");
        map.put("img", String.valueOf(R.drawable.img));
        listItem.add(map);

        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.liste_personnalise,
                new String[] {"img", "identite", "numero"}, new int[] {R.id.img, R.id.identite, R.id.numero});

        listeReq.setAdapter(mSchedule);

        listeReq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Visualier_liste.this, Visualier_profil.class);
                startActivity(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}