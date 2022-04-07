package com.example.amphitryon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class MenuCuisinierActivity extends AppCompatActivity {
    String responseStr ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cuisinier);

        final Button buttonLesPlats = (Button)findViewById(R.id.buttonLesPlats);
        buttonLesPlats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCuisinierActivity.this, LesPlatsActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonGererPlats = (Button)findViewById(R.id.buttonGererPlat);
        buttonGererPlats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCuisinierActivity.this, GestionPlatActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonPropositionPlat = (Button)findViewById(R.id.buttonPropositionPlat);
        buttonPropositionPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuCuisinierActivity.this, GestionPlatActivity.class);
                startActivity(intent);
            }
        });

    }
}