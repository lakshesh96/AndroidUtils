package lg.android_utils;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Audio_Manager extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button changeMode;
    private Spinner modeSpinner;
    private static String mode = "Ring";
    AudioManager ad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio__manager);

        changeMode = (Button) findViewById(R.id.bt7);
        modeSpinner = (Spinner) findViewById(R.id.spinner1);
        ad = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        loadSpinnerData();
        modeSpinner.setOnItemSelectedListener(this);
        changeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMode();
            }
        });
        changeMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(Audio_Manager.this, "Hello!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    private void setMode() {
        if(mode.equals("Silent"))
        {
            ad.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }
        if(mode.equals("Ring"))
        {
            ad.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        }
        if(mode.equals("Vibrate"))
        {
            ad.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        }
    }

    private void loadSpinnerData() {
        List <String> labels = new ArrayList<>();
        labels.add("Ring");
        labels.add("Silent");
        labels.add("Vibrate");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeSpinner.setAdapter(dataAdapter);
    }

    /*@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        *//*mode = modeSpinner.getItemAtPosition(position).toString();
        Toast.makeText(modeSpinner.getContext(), "You Selected: "+mode, Toast.LENGTH_SHORT).show();*//*
    }*/

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        mode = modeSpinner.getItemAtPosition(position).toString();
        Toast.makeText(modeSpinner.getContext(), "You Selected: "+mode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
