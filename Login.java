package com.example.akashpariya.user_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edit1,edit2;
    Button login;
    double id,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.button);
        edit1 = (EditText) findViewById(R.id.editText2);
        edit2 = (EditText) findViewById(R.id.editText3);

    }
    public void login(View view)
    {
        id=Double.parseDouble(edit1.getText()+"0");
        pass=Double.parseDouble(edit2.getText()+"0");
        if(id==12340 && pass==43210)
        {
            Intent i = new Intent(Login.this, choice.class);
            startActivity(i);
        }
        else
            Toast.makeText(Login.this,"Wrong Username or wrong Password",Toast.LENGTH_SHORT).show();
    }
}
