package lg.android_utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Two way Communicating with Calculator Activity

public class Two_Way extends AppCompatActivity {
    EditText et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__way);

        et = (EditText) findViewById(R.id.et);
        bt = (Button) findViewById(R.id.send2);
    }
    public void send2(View view)
    {
        Intent in = new Intent();
        in.putExtra("ack",et.getText().toString());
        setResult(11,in);
        finish();
    }
    protected void onActivityResult(int reqCode, int resCode, Intent dt)
    {
        super.onActivityResult(reqCode,resCode,dt);
        String mes = dt.getStringExtra("key1");
        Toast.makeText(Two_Way.this,"Message Recieved",Toast.LENGTH_SHORT).show();
        et.setText(mes);
    }

}
