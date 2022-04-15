package com.example.amphitryon.plat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.amphitryon.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AjoutPlatActivity extends AppCompatActivity {
    String responseStr ;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_plat);

        final Button buttonEnregistrer = (Button)findViewById(R.id.buttonEnregistrer);
        buttonEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Appel de la fonction ajouter
                try {
                    ajouter();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });
    }

    public void ajouter() throws IOException {

        final EditText textNomPlat = findViewById(R.id.editNomPlat);
        final EditText textCategPlat = findViewById(R.id.editCategoriePlat);
        final EditText textDescriptif = findViewById(R.id.editDescriptif);
        final EditText textPrix = findViewById(R.id.editPrixPlat);

        RequestBody formBody = new FormBody.Builder()
                .add("categorie",  textCategPlat.getText().toString())
                .add("nom", textNomPlat.getText().toString())
                .add("descriptif",  textDescriptif.getText().toString())
                .add("prix",  textPrix.getText().toString())
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.43.119/amphitryon/modeles/dao/plat.php")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            public  void onResponse(Call call, Response response) throws IOException {

                responseStr = response.body().string();
                Log.d("Test","responser" + responseStr);
                if (responseStr.compareTo("false")!=0){
                    Log.d("Test","Ajout effectué");
                }
                else {
                    Log.d("Test","Ajout impossible");
                }
            }

            public void onFailure(Call call, IOException e)
            {
                Log.d("Test","erreur!!! Action impossible");
                Log.d("Test",e.getMessage());
            }

        });
    }
}