package com.example.covid_19trackernepal.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.helper.ConnectionDetector;
import com.example.covid_19trackernepal.model.HospitalReceiveParameters;
import com.example.covid_19trackernepal.model.NepalCovidUpdatesReceiveParameters;
import com.example.covid_19trackernepal.model.WorldCovidUpdatesReceiveParameters;
import com.example.covid_19trackernepal.network.NetworkClient;
import com.example.covid_19trackernepal.network.ServiceGenerator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Home extends Fragment {

    ProgressDialog progressDialog;
    ConnectionDetector connectionDetector;
    View rootView;
    Context context;
    TextView updatedDate, nepalActive, nepalNegative, nepalRecovered, nepalDeath, nepalIsolation, nepalQuarantine, worldCases, worldDeaths, worldRecovered, worldActive, worldCritical, worldAffected;
    private static final String TAG = "Fragment_Home";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        context = getContext();

        updatedDate = rootView.findViewById(R.id.dataUpdatedOn);
        nepalActive = rootView.findViewById(R.id.nepalActiveCases);
        nepalNegative = rootView.findViewById(R.id.nepalNegativeCases);
        nepalRecovered = rootView.findViewById(R.id.nepalRecoveredCases);
        nepalDeath = rootView.findViewById(R.id.nepalDeathCases);
        nepalIsolation = rootView.findViewById(R.id.nepalIsolationCases);
        nepalQuarantine = rootView.findViewById(R.id.nepalQuarantineCases);

        worldCases = rootView.findViewById(R.id.globalTotalCases);
        worldDeaths = rootView.findViewById(R.id.globalTotalDeaths);
        worldRecovered = rootView.findViewById(R.id.globalTotalRecovered);
        worldActive = rootView.findViewById(R.id.globalActiveCases);
        worldCritical = rootView.findViewById(R.id.globalCriticalCases);
        worldAffected = rootView.findViewById(R.id.globalAffectedCountries);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMMM, yyyy");
        String currentDate = sdf.format(new Date());

        updatedDate.setText(currentDate);

        progressDialog = new ProgressDialog(context);
        connectionDetector=new ConnectionDetector(context);

        if (connectionDetector.isNetworkAvailable() || connectionDetector.isDataAvailable()) {
            getCovidData();
        } if(!connectionDetector.isNetworkAvailable() || !connectionDetector.isDataAvailable()){
            progressDialog.dismiss();
            Toasty.error(context,"No Internet Connection!! Please Connect to WIFI or Mobile Data",200).show();
        }

        return  rootView;
    }

    public void getCovidData(){
        NetworkClient networkClient =  ServiceGenerator.createRequestGsonAPI(NetworkClient.class);
        Call<NepalCovidUpdatesReceiveParameters> call = networkClient.getCovidNepalUpdates();

        progressDialog.setMessage("Fetching Data from Server");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();

        call.enqueue(new Callback<NepalCovidUpdatesReceiveParameters>() {
            @Override
            public void onResponse(Call<NepalCovidUpdatesReceiveParameters> call, Response<NepalCovidUpdatesReceiveParameters> response) {
                NepalCovidUpdatesReceiveParameters receiveParameters = response.body();

                nepalActive.setText(String.valueOf(receiveParameters.getTested_positive()));
                nepalNegative.setText(String.valueOf(receiveParameters.getTested_negative()));
                nepalRecovered.setText(String.valueOf(receiveParameters.getRecovered()));
                nepalDeath.setText(String.valueOf(receiveParameters.getDeaths()));
                nepalIsolation.setText(String.valueOf(receiveParameters.getIn_isolation()));
                nepalQuarantine.setText(String.valueOf(receiveParameters.getQuarantined()));

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<NepalCovidUpdatesReceiveParameters> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
                if(progressDialog!= null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }
        });

        NetworkClient networkClient1 =  ServiceGenerator.createRequestGsonAPIforData(NetworkClient.class);
        Call<WorldCovidUpdatesReceiveParameters> call1 = networkClient1.getCovidWorldUpdates();

        call1.enqueue(new Callback<WorldCovidUpdatesReceiveParameters>() {
            @Override
            public void onResponse(Call<WorldCovidUpdatesReceiveParameters> call, Response<WorldCovidUpdatesReceiveParameters> response) {
                WorldCovidUpdatesReceiveParameters receiveParameters = response.body();

                worldCases.setText(String.valueOf(receiveParameters.getCases()));
                worldDeaths.setText(String.valueOf(receiveParameters.getDeaths()));
                worldActive.setText(String.valueOf(receiveParameters.getActive()));
                worldRecovered.setText(String.valueOf(receiveParameters.getRecovered()));
                worldCritical.setText(String.valueOf(receiveParameters.getCritical()));
                worldAffected.setText(String.valueOf(receiveParameters.getAffectedCountries()));

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<WorldCovidUpdatesReceiveParameters> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
                if(progressDialog!= null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }
        });
    }

}
