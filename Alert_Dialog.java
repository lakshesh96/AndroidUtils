package lg.android_utils;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alert_Dialog extends AppCompatActivity {
    ProgressDialog barProgressDialog;
    Handler updateBarHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert__dialog);
        Button btn1 = (Button) findViewById(R.id.alert_btn);
        Button btn2 = (Button) findViewById(R.id.ring_btn);
        Button btn3 = (Button) findViewById(R.id.bar_btn);

        updateBarHandler = new Handler();
    }

    //Code For Alert Dialog Box
    public void submit(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Alert_Dialog.this);
        builder.setTitle("This is Alert Box").setIcon(android.R.drawable.ic_dialog_alert).setMessage("Alert Successfully Implemented");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(Alert_Dialog.this,"Yes Clicked " + which, Toast.LENGTH_SHORT).show();

                //Inorder to apply functions to these buttons use Intent here and perform the requiered functions.
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(Alert_Dialog.this,"No Clicked " + which, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Restart App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(Alert_Dialog.this,"Cancel Clicked " + which, Toast.LENGTH_SHORT).show();
                System.exit(0);
            }
        });
        builder.show();
    }

    //Code for Ring Progress Box
    public void launchRingDialog(View view)
    {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(Alert_Dialog.this,"Please Wait...","Downloading",true);
        //The above "true" is used for flagging whether Box is Indeterminate or not
        ringProgressDialog.setCancelable(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //Here We have time consuming task
                    Thread.sleep(8000);
                }catch(Exception e)
                {

                }
                ringProgressDialog.dismiss();
            }
        })
                .start();
    }

    //Code for Bar Progress Bar
    public void launchBarDialog(View view)
    {
        barProgressDialog = new ProgressDialog(Alert_Dialog.this);
        barProgressDialog.setTitle("Downloading");
        barProgressDialog.setMessage("Download In Progress");
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
        barProgressDialog.setProgress(0);
        barProgressDialog.setMax(20);
        barProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //Here we have time consuming task
                    while(barProgressDialog.getProgress()<=barProgressDialog.getMax())
                    {
                        Thread.sleep(2000);
                        updateBarHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                barProgressDialog.incrementProgressBy(2);
                            }
                        });
                        if(barProgressDialog.getProgress()==barProgressDialog.getMax())
                        {
                            barProgressDialog.dismiss();
                        }
                    }
                }catch(Exception e)
                {

                }
            }
        }).start();
    }

}
