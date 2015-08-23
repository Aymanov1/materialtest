/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package materialtest.vivz.AreYouHealthy.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import materialtest.vivz.slidenerd.materialtest.R;


/**
 *
 * @author AYMEN
 */
public class Respiration extends Activity implements View.OnClickListener{

    ImageView imageView;
    final CounterClass timer = new CounterClass(60000, 1000);
    Button stop, testPoulse,suivant;
    TextView compteur,question;
    EditText getpoulse;
    String txt;
    GlobalVariables a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //To change body of generated methods, choose Tools | Templates.
        setContentView(R.layout.test1);
        a = ((GlobalVariables)getApplicationContext());
        testPoulse = (Button) findViewById(R.id.testPoulse);
        imageView = (ImageView) findViewById(R.id.imageView);
        stop = (Button) findViewById(R.id.stop);
        suivant = (Button) findViewById(R.id.suivant1);
        getpoulse = (EditText) findViewById(R.id.getpoulse);

     //   getpoulse.setFilters(new InputFilter[]{ new InputFilterMinMax("9", "50")});
        compteur = (TextView) findViewById(R.id.compteur);
        question = (TextView) findViewById(R.id.question);
        imageView.setImageResource(R.drawable.breath);
        testPoulse.setOnClickListener(this);
        stop.setOnClickListener(this);
        suivant.setOnClickListener(this);
        compteur.setText("00:01:00");
        question.setText("how many times  do you breath for a minute ?");
    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.testPoulse) {
            timer.start();
            testPoulse.setEnabled(false);

        } else if (i == R.id.stop) {
            timer.cancel();
            testPoulse.setEnabled(true);


        } else if (i == R.id.suivant1) {int j;
            if (isEmpty(getpoulse))  {
                Toast.makeText(getApplicationContext(), "Please enter your number of breath", Toast.LENGTH_SHORT).show();
            }
            else {
                j = Integer.parseInt(getpoulse.getText().toString());

                if (j < 9 || j > 50) {
                    getpoulse.setBackgroundResource(R.drawable.edittextstyle);
                    Toast.makeText(getApplicationContext(), "number of breath must be between 9 and 50", Toast.LENGTH_SHORT).show();
                    //getpoulse.setBackgroundColor(Color.RED);

                } else{

                 Intent intent = new Intent(this, OtherTests.class);

                a.setRespiration(j);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();}
            }
        }
    }

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis=millisUntilFinished;
            String hms= String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            compteur.setText(hms);
            
            
        }

        @Override
        public void onFinish() {
            compteur.setText("completed.");

        }
    }
}
