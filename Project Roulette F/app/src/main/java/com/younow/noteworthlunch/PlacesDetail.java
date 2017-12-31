package com.younow.noteworthlunch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class PlacesDetail extends AppCompatActivity {

    private TextView textViewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_places_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        String placeName = getIntent().getStringExtra("placeName");
        String placeAddress = getIntent().getBundleExtra("bundle").getString("placeAddress");
        textViewLocation = (TextView)findViewById(R.id.place_location);
        textViewLocation.setText(placeAddress);
        toolbar.setTitle(placeName);
        setSupportActionBar(toolbar);
    }

}
