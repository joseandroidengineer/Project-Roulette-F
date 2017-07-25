package com.younow.noteworthlunch;

import android.content.Intent;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonMaps);
        editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address address = MapUtil.getLatLong(getBaseContext(), editText.getText().toString());
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                intent.putExtra("latlonAddress", address);
                startActivity(intent);
            }
        });
    }
}
