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
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import materialtest.vivz.slidenerd.materialtest.R;


/**
 * @author AYMEN
 */
public class TestPoulse extends Activity implements View.OnClickListener {


    ImageView imageView;
    final CounterClass timer = new CounterClass(60000, 1000);
    Button stop, testPoulse, suivant;
    TextView compteur, question;
    EditText getpoulse;
    String txt;
    GlobalVariables a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //To change body of generated methods, choose Tools | Templates.
        setContentView(R.layout.test1);
        a = ((GlobalVariables) getApplicationContext());
        testPoulse = (Button) findViewById(R.id.testPoulse);
        stop = (Button) findViewById(R.id.stop);
        imageView = (ImageView) findViewById(R.id.imageView);
        suivant = (Button) findViewById(R.id.suivant1);
        getpoulse = (EditText) findViewById(R.id.getpoulse);
        getpoulse.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "130")});
        compteur = (TextView) findViewById(R.id.compteur);
        question = (TextView) findViewById(R.id.question);
        testPoulse.setOnClickListener(this);
        stop.setOnClickListener(this);
        suivant.setOnClickListener(this);
        imageView.setImageResource(R.drawable.pulse);
        compteur.setText("00:01:00");
        question.setText("how many heart pulse  do you have for a minute ??");
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
                Toast.makeText(getApplicationContext(), "Please enter your number of heart pulse", Toast.LENGTH_SHORT).show();
                }
            else {
                j = Integer.parseInt(getpoulse.getText().toString());

                if (j < 45 || j > 110) {
                    getpoulse.setBackgroundResource(R.drawable.edittextstyle);

                    Toast.makeText(getApplicationContext(), "number of heart pulse must be between 45 and 110", Toast.LENGTH_SHORT).show();
                    //getpoulse.setBackgroundColor(Color.RED);

                } else{

                    Intent intent = new Intent(this, Respiration.class);

                    a.setCardiacPulse(j);
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
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            compteur.setText(hms);


        }

        @Override
        public void onFinish() {
            compteur.setText("completed.");

        }
    }
}
