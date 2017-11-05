package lg.android_utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import static lg.android_utils.R.id.enter;

public class Translator extends AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener {

    private android.speech.tts.TextToSpeech tts;
    private Button buttonSpeak;
    private EditText editText;


        protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttospeech);

        tts = new android.speech.tts.TextToSpeech(this,this);
        buttonSpeak = (Button) findViewById(R.id.speak_btn);
        editText = (EditText) findViewById(enter);

        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                speakOut();
            }
        });

    }

    @Override
    public void onDestroy()
    {
        //Dont forget to Shutdown
        if(tts!=null)
        {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if(status == android.speech.tts.TextToSpeech.SUCCESS)
        {
            int result = tts.setLanguage(Locale.FRENCH);
            if (result == android.speech.tts.TextToSpeech.LANG_MISSING_DATA || result == android.speech.tts.TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("TTs","This lang is not Supported");
            }
            else{
                buttonSpeak.setEnabled(true);
                speakOut();
            }
        }
    }

    public void speakOut()
    {
        String toSpeak = editText.getText().toString();
        Toast.makeText(getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
        tts.speak(toSpeak, android.speech.tts.TextToSpeech.QUEUE_FLUSH,null);
    }
}