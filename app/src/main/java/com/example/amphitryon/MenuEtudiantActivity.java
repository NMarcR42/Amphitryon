package com.example.amphitryon;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MenuEtudiantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_etudiant);
        /*
        try {
            final JSONObject etudiant = new JSONObject(getIntent().getStringExtra("etudiant"));

            final TextView textIdentification = findViewById(R.id.textIdentification);
            String texteIdentification = etudiant.getString("prenomEtudiant") + " " + etudiant.getString("nomEtudiant");
            textIdentification.setText(texteIdentification);

            final Button buttonLesClasses = findViewById(R.id.buttonLesClasses);
            buttonLesClasses.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuEtudiantActivity.this, ClassesActivity.class);
                    startActivity(intent);

                }
            });

        } catch (JSONException e) {
            Toast.makeText(MenuEtudiantActivity.this, "message !", Toast.LENGTH_SHORT).show();
        }

         */
    }
}


