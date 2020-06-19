package com.example.madrental.BDD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity
{
    private static final String LIEN = "http://s519716619.onlinehome.fr/exchange/madrental/get-vehicules.php";
    private static final String URLIMAGE = "https://i.imgur.com/DvpvklR.png";

    //Vues :
    private RecyclerView recyclerView = null;
    private EditText editTextCars = null;
    private FrameLayout frameLayoutConteneurDetail = null;

    //Adapter:
    private CarsAdapter carsAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vues :
        recyclerView = findViewById(R.id.liste_cars);

        //Ajouter pour de meilleur performances;
        recyclerView.setHasFixedSize(true);

        //layout manager, décrivant comment les items sont disposés :
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //Acces à la base de données
        //final List<CarsDTO> listesCars = AppDatabaseHelper.getDatabase(this).carsDAO().getListeCars();

        AsyncHttpClient client = new AsyncHttpClient();


        frameLayoutConteneurDetail = findViewById(R.id.conteneur_detail);

        client.post(LIEN, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String retour = new String(responseBody);

                Gson gson = new Gson();
                CarsDTO[] retourWS = gson.fromJson(retour,CarsDTO[].class);

                List<CarsDTO> mcList = Arrays.asList(retourWS);

                SendtoAdapter(mcList);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("err", error.toString());
            }
        });
    }

    public void SendtoAdapter(List<CarsDTO> liste)
    {
        CarsAdapter carsAdapter = new CarsAdapter(this,liste);
        recyclerView.setAdapter(carsAdapter);
    }

    public void onClicItem(int position, List<CarsDTO> liste)
    {
        //Récupération de la voiture à cette position :
        CarsDTO carsDTO = liste.get(position);

        //affichage du détail :
        if(frameLayoutConteneurDetail != null) {
            //fragment :
            DetailFrameFragment frameFragment = new DetailFrameFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DetailFrameFragment.EXTRA_NAME, carsDTO.nom);
            frameFragment.setArguments(bundle);

            //Le conteneur de la partie détail est disponible, on est donc en mode tablette :
            getSupportFragmentManager().beginTransaction().replace(R.id.conteneur_detail, frameFragment).commit();
        }
        else
        {
            //Le conteneur de la partie détail n'est pas disponible, on est donc en mode smartphone:
            Intent intent = new Intent(this, DetailFrameActivity.class);
            intent.putExtra(DetailFrameFragment.EXTRA_NAME, carsDTO.nom);
            //intent.putExtra(DetailFrameFragment.EXTRA_PRIX, carsDTO.prixjournalierbase);
            //intent.putExtra(DetailFrameFragment.EXTRA_ECO, carsDTO.categorieco2);

            startActivity(intent);
        }
    }



}
