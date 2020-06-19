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
    public static final String EXTRA_NAME = "CECI est un TEST";

    public DetailFrameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_frame, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getView() != null && getContext() != null && getArguments() != null){
            //Info du fragment !!!
            TextView textView = getView().findViewById(R.id.detail_frame);
            textView.setText(getArguments().getString(EXTRA_NAME));
        }
    }
}
