package materialtest.vivz.slidenerd.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import materialtest.vivz.slidenerd.activities.EnregistrementEtat;
import materialtest.vivz.slidenerd.materialtest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBoxOffice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBoxOffice extends Fragment implements View.OnClickListener {

    ImageButton homme, femme, enfant, about;


    // TODO: Rename and change types and number of parameters
    public static FragmentBoxOffice newInstance(String param1, String param2) {
        FragmentBoxOffice fragment = new FragmentBoxOffice();
        Bundle args = new Bundle();
        //put any extra arguments that you may want to supply to this fragment
        fragment.setArguments(args);
        return fragment;
    }

    public void onMoviesLoaded() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        FragmentActivity FragmentBoxOffice  = (FragmentActivity)    super.getActivity();
        // Replace LinearLayout by the type of the root element of the layout you're trying to load
        LinearLayout llLayout    = (LinearLayout)    inflater.inflate(R.layout.activity_main3, container, false);
        homme = (ImageButton) llLayout.findViewById(R.id.homme);
        femme = (ImageButton) llLayout.findViewById(R.id.femme);
        enfant = (ImageButton) llLayout.findViewById(R.id.enfant);
        about = (ImageButton) llLayout.findViewById(R.id.about);
        about.setOnClickListener(this);
        homme.setOnClickListener(this);
        femme.setOnClickListener(this);
        enfant.setOnClickListener(this);
        return llLayout;


    }



    @Override
    public void onClick(View v){
        Intent intent = new Intent(super.getActivity().getApplicationContext(), EnregistrementEtat.class);
        int i = v.getId();
        if (i == R.id.enfant) {
            intent.putExtra("EnregistrementEtat", "bonjour aymoun");
            startActivityForResult(intent,1);
            // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (i == R.id.femme) {
            intent.putExtra("EnregistrementEtat", "bonjour aymoun");
            startActivityForResult(intent,1);
            // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else if (i == R.id.about) {
            AlertDialog alert = new AlertDialog.Builder(super.getActivity().getApplicationContext()).create();
            alert.setTitle("About us");
            alert.setMessage("Developers : AYMEN JALLABI & Douraid TLILI  ");
            alert.setButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    // Toast.makeText(super.getActivity().getIntent(), "Developed by AYMEN JALLABI & EMNA KACHOUT", Toast.LENGTH_SHORT).show();

                }
            });


            //  alert.setCancelable(false);
            alert.show();

            // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//
        } else if (i == R.id.homme) {
            intent.putExtra("EnregistrementEtat", "bonjour aymoun");
            startActivityForResult(intent,1);
            //  overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            //  Toast.makeText(Intro.this, "If you want to start, press Start", Toast.LENGTH_SHORT).show();


        }
    }
}
