package com.quietsandwich.projectf;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by user on 07/28/17.
 */

public class MapsFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap gMap;
    private MapView mMapView;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.map_fragment, container, false);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        gMap = googleMap;
        Geocoder geocoder = new Geocoder(getContext());
        Bundle bundle = getArguments();

        Address address =  bundle.getParcelable("address");
        // Add a marker in Sydney and move the camera
        LatLng specifiedLocation = new LatLng(address.getLatitude(), address.getLongitude());
        Circle circle = gMap.addCircle
                (new CircleOptions().center(specifiedLocation).radius(500).strokeColor(Color.BLUE).
                        fillColor(Color.argb(
                                50, //This is your alpha.  Adjust this to make it more or less translucent
                                Color.red(Color.BLUE), //Red component.
                                Color.green(Color.BLUE),  //Green component.
                                Color.blue(Color.BLUE))));
        gMap.addMarker(new MarkerOptions().position(specifiedLocation).title("Marker in"+address.getPostalCode()));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(specifiedLocation));
        gMap.setMaxZoomPreference(5000);
        CameraPosition cameraPosition = CameraPosition.builder().target(specifiedLocation).zoom(16).bearing(0).build();
        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }
}
