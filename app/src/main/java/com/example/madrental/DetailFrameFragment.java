package com.example.madrental;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFrameFragment extends Fragment {

    //Constante:
    public static final String EXTRA_NAME = "CECITEST";
    static final String EXTRA_PRIX = "CECITEST";
    private static final String EXTRA_ECO = "CECITEST";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_frame, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        //init :
        super.onActivityCreated(savedInstanceState);
        if(getView() != null && getContext() != null && getArguments() != null)
        {
            //vues :
            TextView textViewNom = getView().findViewById(R.id.detail_frame_nom);
            textViewNom.setText(getArguments().getString(EXTRA_NAME));

            TextView textViewPrix = getView().findViewById(R.id.detail_frame_prix);
            textViewPrix.setText(getArguments().getString(EXTRA_PRIX));

            TextView textViewEco = getView().findViewById(R.id.detail_frame_eco);
            textViewEco.setText(getArguments().getString(EXTRA_ECO));
        }
    }
}
