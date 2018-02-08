package com.cai.ridwan.restphoto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button show_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        show_button = (Button) findViewById(R.id.show_button_id);
        show_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent display_intent = new Intent(MainActivity.this,
                        DisplayRestPictureActivity.class);
                startActivity(display_intent);
            }
        });
    }
}
