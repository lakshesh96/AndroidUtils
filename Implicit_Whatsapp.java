package lg.android_utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Implicit_Whatsapp extends AppCompatActivity {
    EditText et1;
    String link;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit__whatsapp);

        bt2 = (Button) findViewById(R.id.button2);
        et1 = (EditText) findViewById(R.id.input);
        link = et1.getText().toString();

        Button bt = (Button) findViewById(R.id.bt1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0)
            {

                if(et1.getText().toString().equalsIgnoreCase(""))
                {
                    et1.requestFocus();
                    et1.setError("Please Enter Name");
                }
                else {
                    Intent intent = new Intent(/*Intent.ACTION_VIEW, Uri.parse("http://" + et1.getText().toString())*/);
                    intent.setPackage("com.whatsapp");
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, et1.getText().toString());
                    intent.setType("text/plain");
                    startActivity(intent);
                    Toast.makeText(Implicit_Whatsapp.this, "Message Sent Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
