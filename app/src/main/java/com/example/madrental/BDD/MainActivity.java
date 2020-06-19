package com.example.madrental.BDD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.madrental.DetailFrameActivity;
import com.example.madrental.DetailFrameFragment;
import com.example.madrental.adapter.CarsAdapter;
import com.example.madrental.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String LIEN = "http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php";
    private static final String URLIMAGE = "https://i.imgur.com/DvpvklR.png";


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
