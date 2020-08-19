package com.example.covid_19trackernepal.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.fragment.Fragment_Assessment;
import com.example.covid_19trackernepal.fragment.Fragment_Home;
import com.example.covid_19trackernepal.fragment.Fragment_Hospital;
import com.example.covid_19trackernepal.fragment.Fragment_News;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Activity_BottomNav extends AppCompatActivity {

    ProgressDialog progressDialog;
    BottomNavigationView navView;
    FragmentTransaction tx;
    RelativeLayout relativeLayout;
    TextView txtToolbar,txtOptions,txtApprove,txtMessage;
    int status = 0;
    private static final String TAG = "Activity_BottomNav";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    txtToolbar.setText(R.string.title_home);
                    fragment = new Fragment_Home();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_hospitals:
                   txtToolbar.setText(R.string.hospital);
                    fragment = new Fragment_Hospital();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_news:
                    txtToolbar.setText(R.string.news);
                    fragment = new Fragment_News();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_assessment:
                    txtToolbar.setText(R.string.self_checker);
                            fragment = new Fragment_Assessment();
                            loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        navView = findViewById(R.id.nav_view);
        txtToolbar = findViewById(R.id.toolbarText);
        txtOptions = findViewById(R.id.optionsText);

        txtOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v,true,R.style.MyPopupStyle);
            }
        });

        makeActionOverflowMenuShown();
        status = getIntent().getIntExtra("status",0);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(new Fragment_Home());

    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void exitApp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.drawable.ic_attendance);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showPopupMenu(View anchor, boolean isWithIcons, int style) {
        //init the wrapper with style
        Context wrapper = new ContextThemeWrapper(this, style);

        //init the popup
        PopupMenu popup = new PopupMenu(wrapper, anchor);

        /*  The below code in try catch is responsible to display icons*/
        if (isWithIcons) {
            try {
                Field[] fields = popup.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if ("mPopup".equals(field.getName())) {
                        field.setAccessible(true);
                        Object menuPopupHelper = field.get(popup);
                        Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                        Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                        setForceIcons.invoke(menuPopupHelper, true);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.action_faq:
                         finish();
                         Intent intent = new Intent(Activity_BottomNav.this, Activity_FAQ.class);
                         startActivity(intent);
                        break;
                    case R.id.action_symptoms:
                        finish();
                        Intent intent1 = new Intent(Activity_BottomNav.this,Activity_Symptoms.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_prevention:
                        finish();
                        Intent intent2 = new Intent(Activity_BottomNav.this,Activity_Prevention.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });
        popup.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item= menu.findItem(R.id.action_faq);
        item.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private void makeActionOverflowMenuShown() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            Log.d(TAG, e.getLocalizedMessage());
        }
    }

    @Override
    public void onBackPressed() {
       exitApp();
    }
}
