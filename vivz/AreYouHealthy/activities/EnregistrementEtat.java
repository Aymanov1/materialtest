/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materialtest.vivz.AreYouHealthy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import materialtest.vivz.slidenerd.materialtest.R;


/**
 *
 * @author AYMEN
 */
public class EnregistrementEtat extends Activity implements View.OnClickListener {

    Button declancher, annuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //To change body of generated methods, choose Tools | Templates.
        setContentView(R.layout.etat);
        declancher = (Button) findViewById(R.id.declancher);
        declancher.setOnClickListener(this);
        annuler = (Button) findViewById(R.id.annuler);
        annuler.setOnClickListener(this);

    }

    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.declancher) {
            Intent intent = new Intent(this, TestPoulse.class);
            startActivityForResult(intent,1);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        } else if (i == R.id.annuler) {finish();
           // Toast.makeText(this, "first step", Toast.LENGTH_SHORT).show();

        }

    }

}
