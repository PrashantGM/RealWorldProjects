package com.example.covid_19trackernepal.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.adapter.Adapter_News;
import com.example.covid_19trackernepal.app.MyApplication;
import com.example.covid_19trackernepal.helper.ConnectionDetector;
import com.example.covid_19trackernepal.helper.DbHelper;
import com.example.covid_19trackernepal.model.NewsReceiveParameters;
import com.example.covid_19trackernepal.network.NetworkClient;
import com.example.covid_19trackernepal.network.ServiceGenerator;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_News extends Fragment {

    View rootView;
    CoordinatorLayout coordinatorLayout;
    ConnectionDetector cd;
    RecyclerView recyclerView;
    Adapter_News adapterNews;
    List<NewsReceiveParameters.DataBean> newsList=new ArrayList<>();
    ProgressDialog progressDialog;
    TextView txtPrompt1;
    private static final String TAG = "Fragment_News";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_news, container, false);

        coordinatorLayout=rootView.findViewById(R.id.coordinatorLayout);
        txtPrompt1 = rootView.findViewById(R.id.txtNoData1);

        recyclerView=rootView.findViewById(R.id.newsRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutmanager);

        cd=new ConnectionDetector(getContext());

        if (cd.isNetworkAvailable() || cd.isDataAvailable()) {
            getNepalCovidNews();
        } if(!cd.isNetworkAvailable() || !cd.isDataAvailable()){
            progressDialog.dismiss();
            txtPrompt1.setVisibility(View.VISIBLE);
            txtPrompt1.setText("No Internet Connection. Cannot Load Data from Server.");
            Toasty.error(getContext(),"No Internet Connection!! Please Connect to WIFI or Mobile Data",200).show();
        }

        return rootView;
    }

    public void getNepalCovidNews(){
        NetworkClient networkClient =  ServiceGenerator.createRequestGsonAPI(NetworkClient.class);
        Call<NewsReceiveParameters> call = networkClient.getCovidNews();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Fetching Data from Server");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

        call.enqueue(new Callback<NewsReceiveParameters>() {
            @Override
            public void onResponse(Call<NewsReceiveParameters> call, Response<NewsReceiveParameters> response) {
                NewsReceiveParameters newsReceiveParameters = response.body();
                newsList = new ArrayList<>(newsReceiveParameters.getData());
                adapterNews = new Adapter_News(newsList, getContext());
                recyclerView.setAdapter(adapterNews);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<NewsReceiveParameters> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());
                if(progressDialog!= null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }
        });

    }

}
