package com.example.covid_19trackernepal.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.adapter.Adapter_Hospital;
import com.example.covid_19trackernepal.adapter.Adapter_News;
import com.example.covid_19trackernepal.helper.ConnectionDetector;
import com.example.covid_19trackernepal.model.HospitalReceiveParameters;
import com.example.covid_19trackernepal.model.NewsReceiveParameters;
import com.example.covid_19trackernepal.network.NetworkClient;
import com.example.covid_19trackernepal.network.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Hospital extends Fragment {

    View rootView;
    TextView txtPrompt;
    CoordinatorLayout coordinatorLayout;
    ConnectionDetector cd;
    private RecyclerView recyclerView;
    private Adapter_Hospital adapterHospital;
    List<HospitalReceiveParameters.DataBean> hospitalList=new ArrayList<>();
    ProgressDialog progressDialog;
    private static final String TAG = "Fragment_Hospital";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_hospital, container, false);

        coordinatorLayout=rootView.findViewById(R.id.coordinatorLayout);
        txtPrompt = rootView.findViewById(R.id.txtNoData);

        recyclerView=rootView.findViewById(R.id.hospitalRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);

        cd=new ConnectionDetector(getContext());

        if (cd.isNetworkAvailable() || cd.isDataAvailable()) {
            getHospitalData();
        }
        if(!cd.isNetworkAvailable() || !cd.isDataAvailable()){
            progressDialog.dismiss();
            txtPrompt.setVisibility(View.VISIBLE);
            txtPrompt.setText("No Internet Connection. Cannot Load Data from Server.");
            Toasty.error(getContext(),"No Internet Connection!! Please Connect to WIFI or Mobile Data",200).show();
        }

        return rootView;
    }

    private void getHospitalData(){
        NetworkClient networkClient =  ServiceGenerator.createRequestGsonAPI(NetworkClient.class);
        Call<HospitalReceiveParameters> call = networkClient.getCovidHospital();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Fetching Data from Server");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

        call.enqueue(new Callback<HospitalReceiveParameters>() {
            @Override
            public void onResponse(Call<HospitalReceiveParameters> call, Response<HospitalReceiveParameters> response) {
                HospitalReceiveParameters hospitalReceiveParameters = response.body();
                hospitalList = new ArrayList<>(hospitalReceiveParameters.getData());
                adapterHospital = new Adapter_Hospital(hospitalList, getContext());
                recyclerView.setAdapter(adapterHospital);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<HospitalReceiveParameters> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
                if(progressDialog!= null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }
        });
    }
}
