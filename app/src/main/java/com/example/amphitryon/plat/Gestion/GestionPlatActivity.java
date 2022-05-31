package com.example.amphitryon.plat.Gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.amphitryon.R;

public class GestionPlatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_plat);

        final Button buttonAjouterPlat = (Button)findViewById(R.id.buttonAjouterPlat);
        buttonAjouterPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionPlatActivity.this, AjoutPlatActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonModifierPlat = (Button)findViewById(R.id.buttonModifierPlat);
        buttonModifierPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionPlatActivity.this, ModifierPlatActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonSupprimerPlat = (Button)findViewById(R.id.buttonSupprimerPlat);
        buttonSupprimerPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionPlatActivity.this, SupprimerPlatActivity.class);
                startActivity(intent);
            }
        });
    }

}