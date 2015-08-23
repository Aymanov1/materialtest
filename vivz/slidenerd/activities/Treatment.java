package materialtest.vivz.slidenerd.activities;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import materialtest.vivz.slidenerd.materialtest.R;


public class Treatment extends Activity {

    GlobalVariables a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //To change body of generated methods, choose Tools | Templates.
        setContentView(R.layout.treatment);
        final GlobalVariables a = ((GlobalVariables) getApplicationContext());
        TextView txt1 = (TextView) findViewById(R.id.txt1);
        ImageView im = (ImageView) findViewById(R.id.iv);


        //cas mta3 flu 3indah s5ana >39
        //head ache + no9s noum + ta3ab + no9s nfas
        if (a.getIsonomia() == 1 && a.getTired() == 1 &&  a.getTemperature() == 1 &&
                  a.getDiacons() == 0 && a.getDizyyness() == 0
                && a.getCardiacPulse()>60 &&  a.getRespiration()>18
                && a.getChest_ache()==false &&
                a.getHead_ache()==true && a.getBack_ache()==false
                && a.getCardiacPulse() <91
                )

        {
            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.flu));
            txt1.setText("You have (Probably) Flu \n you must see a Doctor for some treatment");
        }


        //cas mta3 problem klawi 3indah
        //head -back ache + no9s noum (insomnia )+ ta3ab fatigue + no9s nfas + do5a dizzy
        else if (a.getIsonomia() == 1 && a.getTired() == 1
                 && a.getTemperature()==0 &&
                 a.getVomit() == 0 && a.getDiacons() == 0 && a.getDizyyness() == 1
                  && a.getCardiacPulse()>65
                && a.getChest_ache()==false &&
                a.getHead_ache()==true && a.getBack_ache()==true  &&
                (a.getRespiration()<20 && a.getRespiration()>12)
                && a.getCardiacPulse() <91)
        {


            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.renal));

            txt1.setText("You have (Probably) Renal problems \n you must see a Doctor for some treatment");

        }

        //cas labas ma bik chay :)


        else if(a.getIsonomia() == 0 && a.getTired() == 0 && a.getChest_ache()==false &&
                a.getHead_ache()==false && a.getBack_ache()==false && a.getTemperature()==0 &&
                a.getVomit() == 0 && a.getDiacons()==0 &&
                a.getDizyyness() == 0 && (a.getRespiration()<20 && a.getRespiration()>12)
                && a.getCardiacPulse() <91 )
        {


            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.good));
            txt1.setText("Congratulations \n you are in good HEALTH \n Carry on !!");



        }else  if (a.getIsonomia() == 0 && a.getTired() == 1 &&  a.getTemperature() == 0 &&
                a.getDiacons() == 0 && a.getDizyyness() == 0 && a.getVomit() ==0
                && a.getCardiacPulse()>60 &&  a.getRespiration()<14
                && a.getChest_ache()==true &&  a.getHead_ache()==true && a.getBack_ache()==false
                )

        {
            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.caugh));
            txt1.setText("You have (Probably) cough \n you must see a Doctor for some treatment");
        }
        //cas karchah touja3 fih ma bik chay :)


        else if( (a.getDiacons() == 1 || a.getDiacons()==2) &&
                a.getDizyyness() == 0 && a.getIsonomia() == 0 && a.getTired() == 0
                && a.getChest_ache()==true &&
                a.getHead_ache()==true && a.getBack_ache()==false && a.getTemperature()==0 &&
                 (a.getRespiration()<20 && a.getRespiration()>12)
                && a.getCardiacPulse() <91)
        {


            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.gastrit));
            txt1.setText("You have (Probably) Gastrit (Estomac-problem) \n" +
                    " you must see a Doctor for some treatment");



        }

        //cas mta3 ka77a
        else if( a.getDiacons() == 0 &&
                a.getDizyyness() == 0 && a.getIsonomia() == 0 && a.getTired() == 0
                && a.getChest_ache()==true && a.getVomit()==0 &&
                a.getHead_ache()==true && a.getBack_ache()==false && a.getTemperature()==0 &&
                ( a.getRespiration()<15)
                && a.getCardiacPulse() <91)
        {


            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.cough));
            txt1.setText("You have (Probably) Cough (Respiration-problem) \n" +
                    " you must see a Doctor for some treatment");



        }
        else if( a.getDiacons() == 0 && a.getVomit()==1 &&
                a.getDizyyness() == 0 && a.getIsonomia() == 0 && a.getTired() == 1
                && a.getChest_ache()==true &&
                a.getHead_ache()==true && a.getBack_ache()==true && a.getTemperature()==1 &&
                a.getRespiration()<15  && a.getCardiacPulse() <91)
        {


            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.tonsille));
            txt1.setText("You have (Probably) pus on the tonsils \n" +
                    " you must see a Doctor for some treatment");



        }
        else if( a.getDiacons() == 0 && a.getVomit()==0 &&
                a.getDizyyness() == 1 && a.getIsonomia() == 0 && a.getTired() == 1
                && a.getChest_ache()==true &&
                a.getHead_ache()==true && a.getBack_ache()==false && a.getTemperature()==1 &&
                a.getRespiration()<15  && a.getCardiacPulse() <91)
        {


            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.flu));
            txt1.setText("You have (Probably) Flu (Respiration-problem) \n" +
                    " you must see a Doctor for some treatment");



        }
        else if( a.getDiacons() == 1 && a.getVomit()==1 &&
                a.getDizyyness() == 1 && a.getIsonomia() == 0 && a.getTired() == 1
                && a.getChest_ache()==true &&
                a.getHead_ache()==true && a.getBack_ache()==false && a.getTemperature()==1 &&
                a.getRespiration()<15  && a.getCardiacPulse() <91)
        {


            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.foodborne));
            txt1.setText("You have (Probably) Foodborne_illness \n" +
                    " you must see a Doctor for some treatment");



        }

        //cas mchna darin 3lih
        else {
            im.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sad));
            txt1.setText("Sorry \n your state is complicated \n You should see a doctor  for more diagnostics!!");
        }



    }


}
