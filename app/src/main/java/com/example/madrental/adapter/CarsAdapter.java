package com.example.madrental.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madrental.BDD.CarsDTO;
import com.example.madrental.BDD.MainActivity;
import com.example.madrental.DetailFrameActivity;
import com.example.madrental.DetailFrameFragment;
import com.example.madrental.R;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.List;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.createDeviceProtectedStorageContext;
import static androidx.core.content.ContextCompat.startActivity;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private List<CarsDTO> listeCars;

    private AsyncHttpResponseHandler mainActivity = null;

    //Smatphone ou pas
    private FrameLayout frameLayoutConteneurDetail = null;


    public CarsAdapter(List<CarsDTO> listeCars) {
        this.listeCars = listeCars;
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewCars = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.car_liste_item, parent, false);
        return new CarsViewHolder(viewCars);
    }

    @Override
    public void onBindViewHolder(@NonNull final CarsViewHolder holder, int position)
    {
        holder.textViewLibelleCars.setText(listeCars.get(position).nom);

        holder.textViewLibelleCarsPrix.setText(listeCars.get(position).prixjournalierbase + "$ / jour");

        holder.textViewLibelleCarsCategorieco2.setText("Categorieco2 : " + listeCars.get(position).categorieco2);

        Picasso.with(holder.imageViewLibelleCars.getContext()).load("http://s519716619.onlinehome.fr/exchange/madrental/images/"+listeCars.get(position).image).into(holder.imageViewLibelleCars);

    }

    @Override
    public int getItemCount() {
        return listeCars.size();
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewLibelleCars;
        public TextView textViewLibelleCarsPrix;
        public TextView textViewLibelleCarsCategorieco2;

        public ImageView imageViewLibelleCars;

        public FrameLayout frameLayout;

        public CarsViewHolder(@NonNull final View itemView) {
            super(itemView);
            textViewLibelleCars = itemView.findViewById(R.id.libelle_cars);
            textViewLibelleCarsPrix = itemView.findViewById(R.id.libelle_cars_prix);
            textViewLibelleCarsCategorieco2 = itemView.findViewById(R.id.libelle_cars_categorieco2);

            imageViewLibelleCars = itemView.findViewById(R.id.image_cars);

            frameLayout = itemView.findViewById(R.id.frame_layout);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {


                    if(frameLayoutConteneurDetail != null){
                        //fragment:

                        DetailFrameFragment frameFragment = new DetailFrameFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString(DetailFrameFragment.EXTRA_NAME, "COUCUO");
                        frameFragment.setArguments(bundle);

                        // le conteneur de la partie détail est disponible, on est donc en mode "tablette"
                        //getSupportFragmentManager().beginTransaction().replace(R.id.conteneur_detail, frameFragment).commit();
                    }
                    else
                    {
                        // le conteneur de la partie détail n'est pas disponible, on est donc en mode "smartphone"
                        Context context = view.getContext();
                        Intent intent = new Intent(view.getContext(), DetailFrameActivity.class);
                        intent.putExtra(DetailFrameFragment.EXTRA_NAME, "Heu");
                        context.startActivity(intent);

                    }
                }
            });

        }
    }
}
