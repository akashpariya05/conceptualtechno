package com.example.akashpariya.user_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class choice extends AppCompatActivity {
ImageButton twitter,facebook,call;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

            twitter = (ImageButton) findViewById(R.id.imageButton7);
            facebook = (ImageButton) findViewById(R.id.imageButton4);
            call = (ImageButton) findViewById(R.id.imageButton11);
    }
    public void facebook(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.facebook.com"));
        startActivity(i);
    }
    public void twitter(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.twitter.com"));
        startActivity(i);
    }
    public void call1(View view) {
        Intent i = new Intent(choice.this, call.class);
        startActivity(i);
    }
}
