package com.example.covid_19trackernepal.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.activity.Activity_BottomNav;
import com.example.covid_19trackernepal.model.AssessmentSendParameters;
import com.rahman.dialog.Activity.SmartDialog;
import com.rahman.dialog.ListenerCallBack.SmartDialogClickListener;
import com.rahman.dialog.Utilities.SmartDialogBuilder;

import es.dmoral.toasty.Toasty;

public class Fragment_Assessment extends Fragment {

    View rootView;
    EditText editAge;
    Button btnSubmit;
    Spinner genderSpinner;
    String[] genderItems = {"Male","Female","Other"};
    String strResult, strAge, strGender, strTemperature, strCough, strAches, strSoreThroat, strDiarrhea, strHeadache, strBreath, strAbroad, strContact, strQuarantine;
    RadioGroup Temperature, Cough, Aches, SoreThroat, Diarrhea, Headache, Breath, Abroad, Contact, Quarantine;
    RadioButton Normal, Fever, HighFever , CoughYes, CoughNo, AchesYes, AchesNo, SoreThroatYes, SoreThroatNo, DiarrheaYes, DiarrheaNo, HeadacheYes, HeadacheNo, BreathYes, BreathNo, AbroadYes, AbroadNo, ContactYes, ContactNo, QuarantineYes, QuarantineNo;
    private static final String TAG = "Activity_Assessment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_assessment, container, false);

        editAge = rootView.findViewById(R.id.edtAge);
        genderSpinner = rootView.findViewById(R.id.genderSpinner);
        Temperature = rootView.findViewById(R.id.rdTemperature);
        Normal = rootView.findViewById(R.id.rdbNormal);
        Fever = rootView.findViewById(R.id.rdbFever);
        Cough = rootView.findViewById(R.id.rdCough);
        CoughYes = rootView.findViewById(R.id.rdbYes1);
        CoughNo = rootView.findViewById(R.id.rdbNo1);
        Aches = rootView.findViewById(R.id.rdAches);
        AchesYes = rootView.findViewById(R.id.rdbYes2);
        AchesNo = rootView.findViewById(R.id.rdbNo2);
        SoreThroat = rootView.findViewById(R.id.rdSoreThroat);
        SoreThroatYes = rootView.findViewById(R.id.rdbYes3);
        SoreThroatNo = rootView.findViewById(R.id.rdbNo3);
        Diarrhea = rootView.findViewById(R.id.rdDiarrhea);
        DiarrheaYes = rootView.findViewById(R.id.rdbYes4);
        DiarrheaNo = rootView.findViewById(R.id.rdbNo4);
        Headache = rootView.findViewById(R.id.rdHeadache);
        HeadacheYes = rootView.findViewById(R.id.rdbYes5);
        HeadacheNo = rootView.findViewById(R.id.rdbNo5);
        Breath = rootView.findViewById(R.id.rdBreath);
        BreathYes = rootView.findViewById(R.id.rdbYes6);
        BreathNo = rootView.findViewById(R.id.rdbNo6);
        Abroad = rootView.findViewById(R.id.rdAbroad);
        AbroadYes = rootView.findViewById(R.id.rdbYes7);
        AbroadNo = rootView.findViewById(R.id.rdbNo7);
        Contact = rootView.findViewById(R.id.rdContact);
        ContactYes = rootView.findViewById(R.id.rdbYes8);
        ContactNo = rootView.findViewById(R.id.rdbNo8);
        Quarantine = rootView.findViewById(R.id.rdQuarantine);
        QuarantineYes = rootView.findViewById(R.id.rdbYes9);
        QuarantineNo = rootView.findViewById(R.id.rdbNo9);
        HighFever = rootView.findViewById(R.id.rdbHighFever);
        btnSubmit = rootView.findViewById(R.id.btnSubmit);

        final Typeface face = Typeface.createFromAsset(getContext().getAssets(),"ptsanswebbold.ttf");
        final Typeface face2 = Typeface.createFromAsset(getContext().getAssets(),"ptsanswebregular.ttf");

        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,genderItems);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(aa);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strGender = genderItems[position];
                // Toasty.success(Activity_Assessment.this,gender,200).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toasty.success(getContext(),"Not selected",200).show();
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strAge = editAge.getText().toString();

                int selectedId = Temperature.getCheckedRadioButtonId();
                RadioButton radioButton = rootView.findViewById(selectedId);
                int selectedId1 = Cough.getCheckedRadioButtonId();
                RadioButton radioButton1 = rootView.findViewById(selectedId1);
                int selectedId2 = Aches.getCheckedRadioButtonId();
                RadioButton radioButton2 = rootView.findViewById(selectedId2);
                int selectedId3 = SoreThroat.getCheckedRadioButtonId();
                RadioButton radioButton3 = rootView.findViewById(selectedId3);
                int selectedId4 = Diarrhea.getCheckedRadioButtonId();
                RadioButton radioButton4 = rootView.findViewById(selectedId4);
                int selectedId5 = Headache.getCheckedRadioButtonId();
                RadioButton radioButton5 = rootView.findViewById(selectedId5);
                int selectedId6 = Breath.getCheckedRadioButtonId();
                RadioButton radioButton6 = rootView.findViewById(selectedId6);
                int selectedId7 = Abroad.getCheckedRadioButtonId();
                RadioButton radioButton7 = rootView.findViewById(selectedId7);
                int selectedId8 = Contact.getCheckedRadioButtonId();
                RadioButton radioButton8 = rootView.findViewById(selectedId8);
                int selectedId9 = Quarantine.getCheckedRadioButtonId();
                RadioButton radioButton9 = rootView.findViewById(selectedId9);

                strTemperature = radioButton.getText().toString();
                strCough = radioButton1.getText().toString();
                strAches = radioButton2.getText().toString();
                strSoreThroat = radioButton3.getText().toString();
                strDiarrhea = radioButton4.getText().toString();
                strHeadache = radioButton5.getText().toString();
                strBreath = radioButton6.getText().toString();
                strAbroad = radioButton7.getText().toString();
                strContact = radioButton8.getText().toString();
                strQuarantine = radioButton9.getText().toString();

                if(strAge.isEmpty() || strAge.trim().equals("")){
                    Toasty.error(getContext(),"Please Enter Your Age",200).show();
                } else if(strAge!=null && strGender!=null && strTemperature.matches(">102") && strCough.matches("Yes") && strAches.matches("Yes") && strSoreThroat.matches("Yes") && strDiarrhea.matches("Yes") && strHeadache.matches("Yes") && strBreath.matches("Yes") && strAbroad.matches("Yes") && strContact.matches("Yes") && strQuarantine.matches("No")){
                    Toasty.success(getContext(),"Data Submitted Successfully",200).show();
                    strResult = "match";
                    new SmartDialogBuilder(getContext())
                            .setTitle("Symptoms Matched!!")
                            .setSubTitle("The details you entered matched with the symptoms of COVID-19. \n\n Please go the Hospital Menu to get the Contact details of your nearest hospital. Please follow the preventive measures to stop from spreading COVID-19.")
                            .setTitleFont(face)
                            .setSubTitleFont(face2)
                            .setCancalable(false)
                            .setNegativeButtonHide(true)
                            .setPositiveButton("OK", new SmartDialogClickListener() {
                                @Override
                                public void onClick(SmartDialog smartDialog) {
                                    smartDialog.dismiss();
                                }
                            }).build().show();
                } else {
                    Toasty.success(getContext(),"Data Submitted Successfully",200).show();
                    strResult = "not match";
                    new SmartDialogBuilder(getContext())
                            .setTitle("Symptoms Didn't Match!!")
                            .setSubTitle("The details you entered didn't match with the symptoms of COVID-19. \n\n Please be self-quarantined. Please be safe and follow all the preventive measure to be safe from COVID-19.")
                            .setTitleFont(face)
                            .setSubTitleFont(face2)
                            .setCancalable(false)
                            .setNegativeButtonHide(true)
                            .setPositiveButton("OK", new SmartDialogClickListener() {
                                @Override
                                public void onClick(SmartDialog smartDialog) {
                                    smartDialog.dismiss();
                                }
                            }).build().show();
                }

                try {
                    AssessmentSendParameters assessmentSendParameters = new AssessmentSendParameters();
                    assessmentSendParameters.age = strAge;
                    assessmentSendParameters.gender = strGender;
                    assessmentSendParameters.temperature = strTemperature;
                    assessmentSendParameters.cough = strCough;
                    assessmentSendParameters.aches = strAches;
                    assessmentSendParameters.sorethroat = strSoreThroat;
                    assessmentSendParameters.diarrhea = strDiarrhea;
                    assessmentSendParameters.headache = strHeadache;
                    assessmentSendParameters.breath = strBreath;
                    assessmentSendParameters.abroad = strAbroad;
                    assessmentSendParameters.contact = strContact;
                    assessmentSendParameters.quarantine = strQuarantine;
                    assessmentSendParameters.result = strResult;
                    assessmentSendParameters.save();
                } catch (Exception e){
                    Log.d(TAG, "Exception: " + e.toString());
                }
            }
        });

        return rootView;
    }


}
