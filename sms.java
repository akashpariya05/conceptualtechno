package com.example.akashpariya.user_app;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class sms extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private ImageButton buttonSpeak;
    private EditText editText;
    private String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        tts= new TextToSpeech(this, this);
        buttonSpeak = (ImageButton) findViewById(R.id.imageButton3);
        editText= (EditText) findViewById(R.id.editText4);
        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
    }
    protected void onDestroy() {
        //Don't forget to shutdown tts!
        if(tts!=null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status== TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.UK);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(sms.this, "This language is not supported", Toast.LENGTH_SHORT).show();
            } else {
                buttonSpeak.setEnabled(true);
                speakOut();
            }
        } else
        {
            Log.e("TTS","INITIALIZATION FAILED");
        }
    }
    private void speakOut() {
        String text = editText.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH,null);

    }
    public void send(View view)
    {
        text= editText.getText()+"";
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("Text/Plain");
        i.putExtra(Intent.EXTRA_TEXT,text);
        startActivity(Intent.createChooser(i,"Share on....."));
    }

}
