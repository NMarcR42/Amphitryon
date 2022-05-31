package com.example.amphitryon.plat.platPropose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.amphitryon.R;
import com.example.amphitryon.plat.Gestion.AjoutPlatActivity;
import com.example.amphitryon.plat.Gestion.GestionPlatActivity;
import com.example.amphitryon.plat.Gestion.ModifierPlatActivity;
import com.example.amphitryon.plat.Gestion.SupprimerPlatActivity;

public class GestionPlatProposeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_plat_propose);

        final Button buttonAjouterProposition = (Button)findViewById(R.id.buttonAjouterProposition);
        buttonAjouterProposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionPlatProposeActivity.this, AjoutPlatProposeActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonModifierProposition = (Button)findViewById(R.id.buttonModifierProposition);
        buttonModifierProposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionPlatProposeActivity.this, ModifierPlatProposeActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonSupprimerProposition = (Button)findViewById(R.id.buttonSupprimerProposition);
        buttonSupprimerProposition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionPlatProposeActivity.this, SupprimerPlatProposeActivity.class);
                startActivity(intent);
            }
        });
    }
}