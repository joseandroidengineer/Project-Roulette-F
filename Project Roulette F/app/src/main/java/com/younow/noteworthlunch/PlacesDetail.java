package com.younow.noteworthlunch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PlacesDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_places_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        String placeName = getIntent().getStringExtra("placeName");
        toolbar.setTitle(placeName);
        setSupportActionBar(toolbar);
    }

}
