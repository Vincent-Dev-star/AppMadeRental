package com.example.madrental.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madrental.BDD.CarsDTO;
import com.example.madrental.R;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private List<CarsDTO> listeCars;

    public CarsAdapter(List<CarsDTO> listeCars)
    {
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
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position)
    {
        holder.textViewLibelleCars.setText(listeCars.get(position).name); //!!!!!!!!!!!
    }

    @Override
    public int getItemCount() {
        return listeCars.size();
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewLibelleCars;

        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLibelleCars = itemView.findViewById(R.id.libelle_cars);
        }
    }
}
