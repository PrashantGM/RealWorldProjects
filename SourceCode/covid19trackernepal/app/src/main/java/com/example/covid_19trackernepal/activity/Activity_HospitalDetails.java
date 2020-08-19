package com.example.covid_19trackernepal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.app.MyApplication;
import com.example.covid_19trackernepal.model.HospitalReceiveParameters;
import com.example.covid_19trackernepal.model.NewsReceiveParameters;
import com.squareup.picasso.Picasso;

public class Activity_HospitalDetails extends AppCompatActivity {

    TextView hosName, hosAddress, hosEmail, hosPhone, hosWebsite, hosContactPerson, hosContactPersonNo, hosTotalBeds, hosTotalVentilators, hosTotalIsolationBeds, hosTotalOccupedBeds, hosTotalDoctors, hosTotalNurses;
    HospitalReceiveParameters.DataBean allHospitals;
    HospitalReceiveParameters.DataBean.CapacityBean capacityBean;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitaldetails);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        hosName = findViewById(R.id.hospitalMainName);
        hosAddress = findViewById(R.id.hospitalMainAddress);
        hosEmail = findViewById(R.id.hospitalMainEmail);
        hosPhone = findViewById(R.id.hospitalMainPhone);
        hosWebsite = findViewById(R.id.hospitalMainWebsite);
        hosContactPerson = findViewById(R.id.hospitalMainContactPerson);
        hosContactPersonNo = findViewById(R.id.hospitalMainContactPersonNo);
        hosTotalBeds = findViewById(R.id.hospitalMainTotalBeds);
        hosTotalVentilators = findViewById(R.id.hospitalMainVentilators);
        hosTotalIsolationBeds = findViewById(R.id.hospitalMainTotalIsolationBeds);
        hosTotalOccupedBeds = findViewById(R.id.hospitalMainTotalOccupiedBeds);
        hosTotalDoctors = findViewById(R.id.hospitalMainTotalDoctors);
        hosTotalNurses = findViewById(R.id.hospitalMainTotalNurses);

        Intent intent = getIntent();
        allHospitals = (HospitalReceiveParameters.DataBean) intent.getSerializableExtra("obj1");

        if(allHospitals.getName().isEmpty()){
            hosName.setText("Not Available");
        } else {
            hosName.setText(allHospitals.getName());
        }

        if(allHospitals.getAddress().isEmpty()){
            hosAddress.setText("Not Available");
        } else {
            hosAddress.setText(allHospitals.getAddress());
        }

        if(allHospitals.getEmail().isEmpty()){
            hosEmail.setText("Not Available");
        } else {
            hosEmail.setText(allHospitals.getEmail());
        }

        if(allHospitals.getPhone().isEmpty()){
            hosPhone.setText("Not Available");
        } else {
            hosPhone.setText(allHospitals.getPhone());
        }

        if(allHospitals.getWebsite().isEmpty()){
            hosWebsite.setText("Not Available");
        } else {
            hosWebsite.setText(allHospitals.getWebsite());
        }

        if(allHospitals.getContact_person().isEmpty()){
            hosContactPerson.setText("Not Available");
        } else {
            hosContactPerson.setText(allHospitals.getContact_person());
        }

        if(allHospitals.getContact_person_number().isEmpty()){
            hosContactPersonNo.setText("Not Available");
        } else {
            hosContactPersonNo.setText(allHospitals.getContact_person_number());
        }

        if(allHospitals.getCapacity().getBeds().isEmpty()){
            hosTotalBeds.setText("Not Available");
        } else {
            hosTotalBeds.setText(allHospitals.getCapacity().getBeds());
        }

        if(allHospitals.getCapacity().getVentilators().isEmpty()){
            hosTotalVentilators.setText("Not Available");
        } else {
            hosTotalVentilators.setText(allHospitals.getCapacity().getVentilators());
        }

        if(allHospitals.getCapacity().getIsolation_beds().isEmpty()){
            hosTotalIsolationBeds.setText("Not Available");
        } else {
            hosTotalIsolationBeds.setText(allHospitals.getCapacity().getIsolation_beds());
        }

        if(allHospitals.getCapacity().getOccupied_beds().isEmpty()){
            hosTotalOccupedBeds.setText("Not Available");
        } else {
            hosTotalOccupedBeds.setText(allHospitals.getCapacity().getOccupied_beds());
        }

        if(allHospitals.getCapacity().getDoctors().isEmpty()){
            hosTotalDoctors.setText("Not Available");
        } else {
            hosTotalDoctors.setText(allHospitals.getCapacity().getDoctors());
        }

        if(allHospitals.getCapacity().getNurses().isEmpty()){
            hosTotalNurses.setText("Not Available");
        } else {
            hosTotalNurses.setText(allHospitals.getCapacity().getNurses());
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(Activity_HospitalDetails.this,Activity_BottomNav.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_slide_out_right,R.anim.anim_slide_in_right);
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent=new Intent(Activity_HospitalDetails.this,Activity_BottomNav.class);
            startActivity(intent);
            overridePendingTransition(R.anim.anim_slide_out_right,R.anim.anim_slide_in_right);
            this.finish();

        }

        return true;
    }
}

