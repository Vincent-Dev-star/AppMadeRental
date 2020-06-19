package com.example.madrental;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DetailFrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //init
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_frame);

        //fragment
        DetailFrameFragment frameFragment = new DetailFrameFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DetailFrameFragment.EXTRA_NAME, getIntent().getStringExtra(DetailFrameFragment.EXTRA_NAME));
        bundle.putString(DetailFrameFragment.EXTRA_PRIX, getIntent().getStringExtra(DetailFrameFragment.EXTRA_PRIX));
        bundle.putString(DetailFrameFragment.EXTRA_NAME, getIntent().getStringExtra(DetailFrameFragment.EXTRA_NAME));
        frameFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.layout_frame_actv, frameFragment).commit();


    }


    public void onClickBoutonFavoris(View view) {

    }
}
