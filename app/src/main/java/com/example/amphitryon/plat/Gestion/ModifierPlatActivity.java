package com.example.amphitryon.plat.Gestion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.amphitryon.R;
import com.example.amphitryon.plat.platPropose.AjoutPlatProposeActivity;

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

public class ModifierPlatActivity extends AppCompatActivity {
    String responseStr ;
    OkHttpClient client = new OkHttpClient();
    Spinner spinnerPlat;
    ArrayList<String> platList = new ArrayList<>();
    ArrayAdapter<String> platAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_plat);

        spinnerPlat = findViewById(R.id.spinnerNomPlat);

        Request request = new Request.Builder()
                .url("http://192.168.1.14/amphitryon/modeles/dao/platListe.php")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {


            public  void onResponse(Call call, Response response) throws IOException {
                String responseStr = response.body().string();
                Log.d("test1", responseStr);
                try {
                    JSONArray jsonArray = new JSONArray(responseStr);
                    Log.d("test2", jsonArray.toString());
                    for(int i=0; i<jsonArray.length();i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.d("test3", jsonObject.getString("nomPlat"));
                        String platName = jsonObject.getString("nomPlat");


                        platList.add(platName);


                    }
                    Log.d("test4",  platList.toString());
                    platAdapter = new ArrayAdapter<>(ModifierPlatActivity.this, android.R.layout.simple_spinner_item, platList);
                    platAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPlat.setAdapter(platAdapter);




                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("test4",e.getMessage());
                }
            }
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("test", "onFailure: "+e.getMessage());


            }
        });



        final Button buttonModifierPlat = (Button)findViewById(R.id.buttonModifierPlat);
        buttonModifierPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Appel de la fonction modifier
                try {
                    modifier();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void modifier() throws IOException {

        final Spinner textNomPlat = findViewById(R.id.spinnerNomPlat);
        final EditText textNouveauNomPlat = findViewById(R.id.editNouveauNomPlat);
        final EditText textNouvelleCategPlat = findViewById(R.id.editNouvelleCategoriePlat);
        final EditText textNouvelleDescriptif = findViewById(R.id.editNouveauDescriptif);

        RequestBody formBody = new FormBody.Builder()
                .add("anomPlat",  textNomPlat.getSelectedItem().toString())
                .add("nnom",  textNouveauNomPlat.getText().toString())
                .add("ncategorie", textNouvelleCategPlat.getText().toString())
                .add("ndescriptif",  textNouvelleDescriptif.getText().toString())
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.1.14/amphitryon/modeles/dao/modifierPlat.php")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            public  void onResponse(Call call, Response response) throws IOException {

                responseStr = response.body().string();
                Log.d("Test","responser" + responseStr);
                if (responseStr.compareTo("false")!=0){
                    Log.d("Test","modification effectué");
                }
                else {
                    Log.d("Test","modification impossible");
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