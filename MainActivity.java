package lg.android_utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calc_bt,btn2, alert_bt,btn_action, twoway_bt, tts_bt,btn6,finger_bt,audio_mgr_bt;
    //For Action Bar
    ActionBar actionBar;
    String btnName;
    //For Notifications
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc_bt = (Button) findViewById(R.id.calc);
        btn2 = (Button) findViewById(R.id.implicit);
        alert_bt = (Button) findViewById(R.id.alert);
        btn_action = (Button) findViewById(R.id.action_btn);
        twoway_bt = (Button) findViewById(R.id.two_way);
        tts_bt = (Button) findViewById(R.id.trans_btn);
        btn6 = (Button) findViewById(R.id.pref_btn);
        finger_bt = (Button) findViewById(R.id.finger);
        audio_mgr_bt = (Button) findViewById(R.id.ad_bt);

        //Code for General Buttons
        calc_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Calc_Activity.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Implicit_Whatsapp.class);
                startActivity(i);
            }
        });

        alert_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Alert_Dialog.class);
                startActivity(i);
            }
        });

        /*twoway_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Two_Way.class);
                startActivity(i);
            }
        });*/

        tts_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Translator.class);
                startActivity(i);
            }
        });

        finger_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,FingerPrint.class);
                startActivity(i);
            }
        });
        audio_mgr_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Audio_Manager.class);
                startActivity(i);
            }
        });


        //Code for Action Bar
        actionBar=getSupportActionBar();
        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });
    }
    public void change()
    {
        btnName = btn_action.getText().toString();
        if(btnName.equalsIgnoreCase("Show"))
        {
            btn_action.setText("hide");
            actionBar.show();
        }
        else
        {
            btn_action.setText("Show");
            actionBar.hide();
        }
    }
    public boolean onCreateOptionsMenu(Menu m1)
    {
        super.onCreateOptionsMenu(m1);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,m1);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        switch(id){
            case R.id.item1:
                Toast.makeText(MainActivity.this,"Item-1 is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this,"Item-2 is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this,"Item-3 is Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(MainActivity.this,"Item-4 is Clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


    //Code For Notifications
    public void callNotif(View view)
    {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent i = new Intent(MainActivity.this,Calc_Activity.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,i,PendingIntent.FLAG_CANCEL_CURRENT);
        builder = new NotificationCompat.Builder(this).setContentTitle("Experience Two Way Communication")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setDefaults(NotificationCompat.DEFAULT_VIBRATE|NotificationCompat.DEFAULT_SOUND|NotificationCompat.DEFAULT_LIGHTS|NotificationCompat.DEFAULT_ALL)
                .setColor(Color.MAGENTA)
                .setNumber(10)
                .setWhen(System.currentTimeMillis())
                .setTicker("Two way Enabled");
        int notifId = 101;
        notificationManager.notify(notifId,builder.build());
    }

}
