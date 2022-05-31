package com.example.amphitryon.plat.Gestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.amphitryon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LesPlatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_plats);

        try {
            tabPlat();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void tabPlat() throws IOException {

        OkHttpClient client = new OkHttpClient();
        ArrayList arrayListNomClasses = new ArrayList<String>();

        Request request = new Request.Builder()
                .url("http://192.168.1.14/amphitryon/modeles/dao/afficherTabPlat.php")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            public void onResponse(Call call, Response response) throws IOException {
                String responseStr = response.body().string();
                JSONArray jsonArrayClasses = null;
                try {
                    jsonArrayClasses = new JSONArray(responseStr);

                    for (int i = 0; i < jsonArrayClasses.length(); i++) {
                        JSONObject jsonClasse = null;
                        jsonClasse = jsonArrayClasses.getJSONObject(i);
                        arrayListNomClasses.add(jsonClasse.getString("idPlat")+ jsonClasse.getString("idCategorie")+ jsonClasse.getString("nomPlat")+ jsonClasse.getString("descriptifPlat"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                ListView listViewClasses = findViewById(R.id.listViewListePlat);

                ArrayAdapter<String> arrayAdapterClasses = new ArrayAdapter<String>(LesPlatsActivity.this, android.R.layout.simple_list_item_1, arrayListNomClasses);

                listViewClasses.setAdapter(arrayAdapterClasses);
                JSONArray finalJsonArrayClasses = jsonArrayClasses;

                listViewClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        JSONObject unPlat = finalJsonArrayClasses.getJSONObject(position);
                        Intent intent = new Intent(LesPlatsActivity.this, AjoutPlatActivity.class);
                        intent.putExtra("unPlat" , unPlat.toString());
                        startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }});


            }

            public void onFailure(Call call, IOException e) {
                Log.d("Test", "erreur!!! connexion impossible");
            }


        });
    }

}