package com.younow.noteworthlunch;

import android.content.Intent;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZipActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);

        Button button = (Button) findViewById(R.id.buttonMaps);
        editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Address address = MapUtil.getLatLong(getBaseContext(), editText.getText().toString());
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("latlonAddress", address);
                startActivity(intent);
            }
        });
    }
}
