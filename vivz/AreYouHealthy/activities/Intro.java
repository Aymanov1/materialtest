package materialtest.vivz.AreYouHealthy.activities;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import materialtest.vivz.slidenerd.materialtest.R;


public class Intro extends Activity implements View.OnClickListener{
    ImageButton homme, femme, enfant, about;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        homme = (ImageButton) findViewById(R.id.homme);
        femme = (ImageButton) findViewById(R.id.femme);
        enfant = (ImageButton) findViewById(R.id.enfant);
        about = (ImageButton) findViewById(R.id.about);
        about.setOnClickListener(this);
        homme.setOnClickListener(this);
        femme.setOnClickListener(this);
        enfant.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, EnregistrementEtat.class);
        int i = v.getId();
        if (i == R.id.enfant) {
            intent.putExtra("EnregistrementEtat", "bonjour aymoun");
            startActivityForResult(intent,1);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (i == R.id.femme) {
            intent.putExtra("EnregistrementEtat", "bonjour aymoun");
            startActivityForResult(intent,1);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (i == R.id.about) {
            AlertDialog alert = new AlertDialog.Builder(Intro.this).create();
            alert.setTitle("About us");
            alert.setMessage("Developers : AYMEN JALLABI & EMNA KACHOUT   GI2 TRANSMEDIA FOR IA PROJECT");
            alert.setButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(Intro.this, "Developed by AYMEN JALLABI & EMNA KACHOUT", Toast.LENGTH_SHORT).show();

                }
            });


            //  alert.setCancelable(false);
            alert.show();

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (i == R.id.homme) {
            intent.putExtra("EnregistrementEtat", "bonjour aymoun");
            startActivityForResult(intent,1);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            Toast.makeText(Intro.this, "If you want to start, press Start", Toast.LENGTH_SHORT).show();


        }
    }

}
