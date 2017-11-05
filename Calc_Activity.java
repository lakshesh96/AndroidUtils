package lg.android_utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calc_Activity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText result,result2;
    Button add,ret1,send;
    float a,b;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_);

        add = (Button) findViewById(R.id.button1);
        et1 = (EditText) findViewById(R.id.num1);
        et2 = (EditText) findViewById(R.id.num2);
        result = (EditText) findViewById(R.id.result);
        ret1 = (Button) findViewById(R.id.button5);
        send = (Button) findViewById(R.id.button6);
        result2 = (EditText) findViewById(R.id.result2);
        //final Intent i = getIntent();
        //getIntent();


        ret1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        }
        );

    }

    public void add(View v)
    {

        try {
            String num1 = et1.getText().toString();
            String num2 = et2.getText().toString();
            a = Float.parseFloat(num1);
            b = Float.parseFloat(num2);
            if (et1.getText().toString().equalsIgnoreCase("")) {
                et1.requestFocus();
                et1.setError("Please enter a number first.");
            }
            else if (et2.getText().toString().equalsIgnoreCase("")) {
                et2.requestFocus();
                et2.setError("Please enter a number first.");
            }
            else {
                float res = a + b;
                result.setText("" + res);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void sub(View v)
    {
        try {
            String num1 = et1.getText().toString();
            String num2 = et2.getText().toString();
            a = Float.parseFloat(num1);
            b = Float.parseFloat(num2);
            float res = a - b;
            result.setText("" + res);
        }catch(Exception e)
        {

        }
    }
        public void mul (View v)
        {
            try {
                String num1 = et1.getText().toString();
                String num2 = et2.getText().toString();
                a = Float.parseFloat(num1);
                b = Float.parseFloat(num2);
                float res = a * b;
                result.setText("" + res);
            }catch(Exception e)
            {

            }
        }

    public void div(View v) {
        try {
            String num1 = et1.getText().toString();
            String num2 = et2.getText().toString();
            a = Float.parseFloat(num1);
            b = Float.parseFloat(num2);
            float res = a / b;
            result.setText("" + res);
        }catch(Exception e)
        {

        }
    }

    //For Sending result to Other Activity

    public void sendResult(View view)
    {
        String data = result.getText().toString();
        Intent i = new Intent(Calc_Activity.this,Two_Way.class);
        i.putExtra("key1",data);
        startActivityForResult(i,10);
        Toast.makeText(Calc_Activity.this,"Result Sent",Toast.LENGTH_SHORT).show();
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        String msg = data.getStringExtra("ack");
        result2.setText(msg);
    }
}