package com.example.madrental.BDD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.madrental.adapter.CarsAdapter;
import com.example.madrental.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String LIEN = "http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.liste_cars);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        //Acces à la base de données
        //final List<CarsDTO> listesCars = AppDatabaseHelper.getDatabase(this).carsDAO().getListeCars();

        AsyncHttpClient client = new AsyncHttpClient();

        /*
        RequestParams requestParams = new RequestParams();
        requestParams.put("parametre", "1234");
        */

        client.post(LIEN, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String retour = new String(responseBody);

                Gson gson = new Gson();
                CarsDTO[] retourWS = gson.fromJson(retour,CarsDTO[].class);


                        //get values with DAO
                        final List<CarsDTO> listesCars = new ArrayList<>();
                        listesCars.add(new CarsDTO(1, "chien","test",1,2,3,'c'));
                        listesCars.add(new CarsDTO(1, "chat","test",1,2,3,'c'));


                List<CarsDTO> mcList = Arrays.asList(retourWS);

                Log.d("anim", String.valueOf(mcList));

                CarsAdapter carsAdapter = new CarsAdapter(mcList);

                recyclerView.setAdapter(carsAdapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("err", error.toString());
            }
        });



    }
}
