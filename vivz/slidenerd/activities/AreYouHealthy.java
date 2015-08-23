package materialtest.vivz.slidenerd.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import materialtest.vivz.slidenerd.materialtest.R;


public class AreYouHealthy extends Activity {
    ProgressBar pgr;
    int progress = 0;
    Handler h=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    pgr=(ProgressBar)findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<4;i++)
                {progress+=25;
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            pgr.setProgress(progress);
                            if(progress==pgr.getMax())
                            {Intent i=new Intent(getApplicationContext(), MainMenu.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                i.putExtra("EXIT", true);
                                startActivity(i);
                                finish();

                        }}
                    });
                    try{
                        Thread.sleep(1500);
                    }catch(InterruptedException e)
                    {

                    }

            }
            }
        }).start();



    }




}
