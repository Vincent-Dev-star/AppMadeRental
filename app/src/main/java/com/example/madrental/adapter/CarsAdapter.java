package com.example.madrental.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madrental.BDD.CarsDTO;
import com.example.madrental.BDD.MainActivity;
import com.example.madrental.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    //Liste d'object métier:
    private List<CarsDTO> listeCars;

    //Activité :
    private MainActivity mainActivity = null;

    public CarsAdapter(MainActivity mainActivity, List<CarsDTO> listeCars) {
        this.listeCars = listeCars;
        this.mainActivity = mainActivity;
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


    public CarsDTO getItemParPosition(int position)
    {
        return listeCars.get(position);
    }

    class CarsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewLibelleCars;
        TextView textViewLibelleCarsPrix;
        TextView textViewLibelleCarsCategorieco2;

        ImageView imageViewLibelleCars;

        FrameLayout frameLayout;

        CarsViewHolder(@NonNull final View itemView) {
            super(itemView);
            textViewLibelleCars = itemView.findViewById(R.id.libelle_cars);
            textViewLibelleCarsPrix = itemView.findViewById(R.id.libelle_cars_prix);
            textViewLibelleCarsCategorieco2 = itemView.findViewById(R.id.libelle_cars_categorieco2);

            imageViewLibelleCars = itemView.findViewById(R.id.image_cars);

            frameLayout = itemView.findViewById(R.id.frame_layout);

            // listener :
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    mainActivity.onClicItem(getAdapterPosition(), listeCars);
                }
            });

        }
    }
}
