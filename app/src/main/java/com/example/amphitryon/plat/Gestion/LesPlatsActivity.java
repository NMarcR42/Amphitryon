package com.example.amphitryon.plat.platPropose;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.amphitryon.R;

public class LesPlatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_plats);

        /*PlatDAO platDAO = new PlatDAO(this);

        Cursor curseur = platDAO.getTousLesPlats();

        ListView listViewListePlat = findViewById(R.id.listViewListePlat);

        final SimpleCursorAdapter adapter = new SimpleCursorAdapter(MesGroupesActivity.this,
                android.R.layout.simple_list_item_1, curseur,new String[]{"nomGroupe"},
                new int[]{android.R.id.text1 },0);

        listViewListePlat.setAdapter(adapter);*/
    }
}