package com.example.madrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class DetailFrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_frame);

        DetailFrameFragment frameFragment = new DetailFrameFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DetailFrameFragment.EXTRA_NAME, getIntent().getStringExtra(DetailFrameFragment.EXTRA_NAME));
        frameFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.layout_frame_frag, frameFragment).commit();


    }








}
