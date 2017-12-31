package com.younow.noteworthlunch;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

/**
 * Created by user on 07/25/17.
 */

public class MapUtil {

    public static Address getLatLong(Context context, String zip ){
        final Geocoder geocoder = new Geocoder(context);
        Address address = null;
        try {
            List<Address> addresses = geocoder.getFromLocationName(zip, 1);
            if (addresses != null && !addresses.isEmpty()) {
                address = addresses.get(0);
                // Use the address as needed
                String message = String.format("Latitude: %f, Longitude: %f", address.getLatitude(), address.getLongitude());
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                return address;
            } else {
                // Display appropriate message when Geocoder services are not available
                Toast.makeText(context, "Unable to geocode zipcode", Toast.LENGTH_LONG).show();
                return null;
            }
        } catch (IOException e) {
            //

        }
        return address;
    }

    public static LatLng getLatLongFrom(Context context, String strAddress){
        final Geocoder geocoder = new Geocoder(context);
        LatLng latLng = new LatLng(0,0);
        Address address;

        try{
            List<Address> addresses = geocoder.getFromLocationName(strAddress, 1);
            address = addresses.get(0);
            latLng = new LatLng(address.getLatitude(),address.getLongitude());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latLng;

    }
}
