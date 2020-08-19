package com.example.covid_19trackernepal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.app.MyApplication;
import com.example.covid_19trackernepal.model.NewsReceiveParameters;
import com.squareup.picasso.Picasso;

public class Activity_NewsDescription extends AppCompatActivity {

    TextView title, description, source;
    ImageView news_image;
    NewsReceiveParameters.DataBean allnews;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        news_image = (ImageView) findViewById(R.id.newsImage);
        title = (TextView) findViewById(R.id.newsLongTitle);
        description = (TextView) findViewById(R.id.newsLongDescription);
        source = findViewById(R.id.newsSource);

        Intent intent = getIntent();
        allnews = (NewsReceiveParameters.DataBean) intent.getSerializableExtra("obj");

        title.setText(Html.fromHtml(allnews.getTitle().replace("\\n","")));
        description.setText(Html.fromHtml(allnews.getSummary().replace("\\n","<br />")));
        source.setText(Html.fromHtml(allnews.getSource().replace("\\n","<br />")));
        Picasso.with(getApplicationContext())
                .load(allnews.getImage_url())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.no_image)
                .into(news_image);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent=new Intent(Activity_NewsDescription.this,Activity_BottomNav.class);
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
            Intent intent=new Intent(Activity_NewsDescription.this,Activity_BottomNav.class);
            startActivity(intent);
            overridePendingTransition(R.anim.anim_slide_out_right,R.anim.anim_slide_in_right);
            this.finish();

        }

        if(id == R.id.viewWeb) {

            String news_url = allnews.getUrl();
            MyApplication.showWebView(news_url);
        }

        if(id == R.id.shareNews){
            String WebLink=allnews.getUrl();
            sharePost(WebLink);
        }
        return true;
    }

    public void sharePost(String postUrl){
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "\n\n");
        shareIntent.putExtra(Intent.EXTRA_TEXT, postUrl);
        startActivity(Intent.createChooser(shareIntent, "Share Using"));

    }
}
