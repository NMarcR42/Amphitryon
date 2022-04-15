package com.example.amphitryon.plat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

public class SupprimerPlatActivity extends AppCompatActivity {
    String responseStr ;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_plat);
    }
    public void supprimer() throws IOException {

        final EditText textNomPlat = findViewById(R.id.editNomPlat);

        RequestBody formBody = new FormBody.Builder()
                .add("nom", textNomPlat.getText().toString())
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.43.119/amphitryon/modeles/dao/supprimerPlat.php")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            public  void onResponse(Call call, Response response) throws IOException {

                responseStr = response.body().string();
                Log.d("Test","responser" + responseStr);
                if (responseStr.compareTo("false")!=0){
                    Log.d("Test","suppression effectué");
                }
                else {
                    Log.d("Test","suppression impossible");
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