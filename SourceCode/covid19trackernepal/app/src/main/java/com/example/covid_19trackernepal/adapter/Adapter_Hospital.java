package com.example.covid_19trackernepal.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.activity.Activity_HospitalDetails;
import com.example.covid_19trackernepal.activity.Activity_NewsDescription;
import com.example.covid_19trackernepal.model.HospitalReceiveParameters;
import com.example.covid_19trackernepal.model.NewsReceiveParameters;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class Adapter_Hospital extends RecyclerView.Adapter<Adapter_Hospital.ViewHolder>{

    Context context;
    List<HospitalReceiveParameters.DataBean> hospitalList = new ArrayList<>();
    private static final String TAG = "Adapter_Hospital";

    public Adapter_Hospital(List<HospitalReceiveParameters.DataBean> hospitalList,Context context) {
        this.hospitalList = hospitalList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_Hospital.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hospital_single_item, viewGroup, false);
        Adapter_Hospital.ViewHolder holder=new Adapter_Hospital.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final HospitalReceiveParameters.DataBean pos1 = hospitalList.get(i);

        if(pos1.getName().isEmpty()){
            viewHolder.name.setText("Not Available");
        } else {
            viewHolder.name.setText(pos1.getName());
        }

        if(pos1.getPhone().isEmpty()){
            viewHolder.phone.setText("Not Available");
        } else {
            viewHolder.phone.setText(pos1.getPhone());
        }

        if(pos1.getAddress().isEmpty()){
            viewHolder.address.setText("Not Available");
        } else {
            viewHolder.address.setText(pos1.getAddress());
        }

        if(pos1.getContact_person().isEmpty()){
            viewHolder.contactPerson.setText("Not Available");
        } else {
            viewHolder.contactPerson.setText(pos1.getContact_person());
        }

        if(pos1.getContact_person_number().isEmpty()){
            viewHolder.contactPersonNo.setText("Not Available");
        } else {
            viewHolder.contactPersonNo.setText(pos1.getContact_person_number());
        }

        viewHolder.btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), Activity_HospitalDetails.class);
                    intent.putExtra("obj1",pos1);
                    Activity activity = (Activity) context;
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.anim_slide_out_right,R.anim.anim_slide_in_right);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, contactPerson, contactPersonNo, phone, address;
        Button btnInfo;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.hospitalName);
            contactPerson = view.findViewById(R.id.contactPerson);
            contactPersonNo = view.findViewById(R.id.contactPersonNumber);
            phone = view.findViewById(R.id.hospitalPhone);
            address = view.findViewById(R.id.hospitalAddress);
            btnInfo = view.findViewById(R.id.btnMore);
        }
    }
}

