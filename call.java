package com.example.akashpariya.user_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class call extends AppCompatActivity {
ImageButton phone;
    EditText number;
    String num;
    ListView listview1;
    String contacts[]={ "akash","ajit","rishabh","harry"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        listview1=(ListView)findViewById(R.id.listview1);
        phone = (ImageButton) findViewById(R.id.imageButton);
        number = (EditText) findViewById(R.id.editText);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,contacts);
        listview1.setAdapter(adapter);
        registerForContextMenu(listview1);



    }
    public void dial(View view) {
        num=("tel:"+number.getText()+"");
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse(num));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(i);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,v.getId(),0,"CALL");
        menu.add(0,v.getId(),0,"SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="CALL")
        {


        }
        else if(item.getTitle()=="SMS")
        {
            Toast.makeText(getApplicationContext(),"Sending SMS code",Toast.LENGTH_LONG);
            Intent i1=new Intent(call.this,sms.class);
            startActivity(i1);
        }
        else
        {
            return false;
        }
        return  true;

    }



}

