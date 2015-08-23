package materialtest.vivz.AreYouHealthy.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import materialtest.vivz.slidenerd.materialtest.R;

public class ActivityA extends ActionBarActivity implements View.OnClickListener{
    int requestCode,resultCode;
    Button start,exit,settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        start = (Button) findViewById(R.id.start);
        settings = (Button) findViewById(R.id.settings);
        exit = (Button) findViewById(R.id.exit);

        start.setOnClickListener(this);
        settings.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, Intro.class);
        int i = v.getId();
        if (i == R.id.exit) {
            if (getIntent().getBooleanExtra("EXIT", false)) {
                android.os.Process.killProcess(android.os.Process.myPid());
                super.onDestroy();
            }
        } else if (i == R.id.settings) {
            AlertDialog alert = new AlertDialog.Builder(ActivityA.this).create();
            alert.setTitle("About us");
            alert.setMessage("Developers : AYMEN JALLABI ");
            alert.setButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {


                }
            });
            //  alert.setCancelable(false);
            alert.show();
        }  else if (i == R.id.start) {

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        }
    }}