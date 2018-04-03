package com.quietsandwich.projectf;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class ZipActivity extends AppCompatActivity {

    private EditText editText;
    int PLACE_PICKER_REQUEST = 1;
    private Activity activity = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);

        Button button = (Button) findViewById(R.id.buttonMaps);
        ImageButton buttonPlaces = (ImageButton) findViewById(R.id.image_button_places);
        Button buttonOtherMap = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length() < 5){
                    Toast.makeText(activity,"Please enter a 5 digit zipcode", Toast.LENGTH_SHORT).show();
                }else{
                    Address address = MapUtil.getLatLong(getBaseContext(), editText.getText().toString());
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.putExtra("latlonAddress", address);
                    startActivity(intent);
                }
            }
        });

        buttonPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(activity), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonOtherMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().length() < 5){
                    Toast.makeText(activity,"Please enter a 5 digit zipcode", Toast.LENGTH_SHORT).show();
                }else{
                    Address address = MapUtil.getLatLong(getBaseContext(), editText.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                    intent.putExtra("latlonAddress", address);
                    startActivity(intent);
                }

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = new Bundle();
                Place place = PlacePicker.getPlace(this, data);

                String toastMsg = String.format("Place: %s", place.getName());
                bundle.putString("placeName", String.format("%s",place.getName()));
                bundle.putString("placeAddress", String.format("%s",place.getAddress()));
                bundle.putString("placePhone", String.format("%s",place.getPhoneNumber()));
                bundle.putInt("placePrice", place.getPriceLevel());
                bundle.putString("placeLocale", String.format("%s",place.getLocale()));
                bundle.putFloat("placeRating", place.getRating());

                Intent intent = new Intent(activity, PlacesDetail.class);
                intent.putExtra("places", (Parcelable) place);
                intent.putExtra("placeName", String.format("%s",place.getName()));
                intent.putExtra("bundle", bundle);
                startActivity(intent);
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }
}
