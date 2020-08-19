package com.example.covid_19trackernepal.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.adapter.Adapter_ExpandableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Activity_FAQ extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    Adapter_ExpandableList listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        expListView = findViewById(R.id.expandableListView);
        prepareListData();
        listAdapter = new Adapter_ExpandableList(Activity_FAQ.this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }


    private void prepareListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add(getString(R.string.faq0_title));
        listDataHeader.add(getString(R.string.faq1_title));
        listDataHeader.add(getString(R.string.faq2_title));
        listDataHeader.add(getString(R.string.faq3_title));
        listDataHeader.add(getString(R.string.faq4_title));
        listDataHeader.add(getString(R.string.faq5_title));
        listDataHeader.add(getString(R.string.faq6_title));
        listDataHeader.add(getString(R.string.faq7_title));
        listDataHeader.add(getString(R.string.faq8_title));
        listDataHeader.add(getString(R.string.faq9_title));
        listDataHeader.add(getString(R.string.faq10_title));
        listDataHeader.add(getString(R.string.faq11_title));
        listDataHeader.add(getString(R.string.faq12_title));
        listDataHeader.add(getString(R.string.faq13_title));
        listDataHeader.add(getString(R.string.faq14_title));
        listDataHeader.add(getString(R.string.faq15_title));
        listDataHeader.add(getString(R.string.faq16_title));
        listDataHeader.add(getString(R.string.faq17_title));
        listDataHeader.add(getString(R.string.faq18_title));
        listDataHeader.add(getString(R.string.faq19_title));

        List<String> faq0 = new ArrayList<String>();
        faq0.add(getString(R.string.faq0_desc));

        List<String> faq1 = new ArrayList<String>();
        faq1.add(getString(R.string.faq1_desc));

        List<String> faq2 = new ArrayList<String>();
        faq2.add(getString(R.string.faq2_desc));

        List<String> faq3 = new ArrayList<String>();
        faq3.add(getString(R.string.faq3_desc));

        List<String> faq4 = new ArrayList<String>();
        faq4.add(getString(R.string.faq4_desc));

        List<String> faq5 = new ArrayList<String>();
        faq5.add(getString(R.string.faq5_desc));

        List<String> faq6 = new ArrayList<String>();
        faq6.add(getString(R.string.faq6_desc));

        List<String> faq7 = new ArrayList<String>();
        faq7.add(getString(R.string.faq7_desc));

        List<String> faq8 = new ArrayList<String>();
        faq8.add(getString(R.string.faq8_desc));

        List<String> faq9 = new ArrayList<String>();
        faq9.add(getString(R.string.faq9_desc));

        List<String> faq10 = new ArrayList<String>();
        faq10.add(getString(R.string.faq10_desc));

        List<String> faq11 = new ArrayList<String>();
        faq11.add(getString(R.string.faq11_desc));

        List<String> faq12 = new ArrayList<String>();
        faq12.add(getString(R.string.faq12_desc));

        List<String> faq13 = new ArrayList<String>();
        faq13.add(getString(R.string.faq13_desc));

        List<String> faq14 = new ArrayList<String>();
        faq14.add(getString(R.string.faq14_desc));

        List<String> faq15 = new ArrayList<String>();
        faq15.add(getString(R.string.faq15_desc));

        List<String> faq16 = new ArrayList<String>();
        faq16.add(getString(R.string.faq16_desc));

        List<String> faq17 = new ArrayList<String>();
        faq17.add(getString(R.string.faq17_desc));

        List<String> faq18 = new ArrayList<String>();
        faq18.add(getString(R.string.faq18_desc));

        List<String> faq19 = new ArrayList<String>();
        faq19.add(getString(R.string.faq19_desc));

        listDataChild.put(listDataHeader.get(0), faq0);
        listDataChild.put(listDataHeader.get(1), faq1);
        listDataChild.put(listDataHeader.get(2), faq2);
        listDataChild.put(listDataHeader.get(3), faq3);
        listDataChild.put(listDataHeader.get(4), faq4);
        listDataChild.put(listDataHeader.get(5), faq5);
        listDataChild.put(listDataHeader.get(6), faq6);
        listDataChild.put(listDataHeader.get(7), faq7);
        listDataChild.put(listDataHeader.get(8), faq8);
        listDataChild.put(listDataHeader.get(9), faq9);
        listDataChild.put(listDataHeader.get(10), faq10);
        listDataChild.put(listDataHeader.get(11), faq11);
        listDataChild.put(listDataHeader.get(12), faq12);
        listDataChild.put(listDataHeader.get(13), faq13);
        listDataChild.put(listDataHeader.get(14), faq14);
        listDataChild.put(listDataHeader.get(15), faq15);
        listDataChild.put(listDataHeader.get(16), faq16);
        listDataChild.put(listDataHeader.get(17), faq17);
        listDataChild.put(listDataHeader.get(18), faq18);
        listDataChild.put(listDataHeader.get(19), faq19);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(Activity_FAQ.this,Activity_BottomNav.class);
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
            Intent intent=new Intent(Activity_FAQ.this,Activity_BottomNav.class);
            startActivity(intent);
            overridePendingTransition(R.anim.anim_slide_out_right,R.anim.anim_slide_in_right);
            this.finish();

        }

        return true;
    }
}
