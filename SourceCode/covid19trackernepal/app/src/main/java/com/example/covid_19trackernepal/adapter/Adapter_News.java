package com.example.covid_19trackernepal.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.covid_19trackernepal.R;
import com.example.covid_19trackernepal.activity.Activity_NewsDescription;
import com.example.covid_19trackernepal.model.NewsReceiveParameters;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter_News extends RecyclerView.Adapter<Adapter_News.ViewHolder> {

    Context context;
    List<NewsReceiveParameters.DataBean> newsList=new ArrayList<>();
    private static final String TAG = "Adapter_News";

    public Adapter_News(List<NewsReceiveParameters.DataBean> newsList,Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_News.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_single_item, viewGroup, false);
        Adapter_News.ViewHolder holder=new Adapter_News.ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_News.ViewHolder viewHolder, int i) {
        final NewsReceiveParameters.DataBean pos = newsList.get(i);

        viewHolder.news_title.setText(Html.fromHtml(pos.getTitle().replace("\\n", "")));
        viewHolder.news_short_desc.setText(Html.fromHtml(pos.getSummary().replace("<br>", "").replace("<br />", "")));
        Picasso.with(context)
                .load(pos.getImage_url())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.no_image)
                .into(viewHolder.news_image);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), Activity_NewsDescription.class);
                intent.putExtra("obj",pos);
                Activity activity = (Activity) context;
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.anim_slide_out_right,R.anim.anim_slide_in_right);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView news_image;
        TextView news_title,news_short_desc;

        private ViewHolder(View itemView) {
            super(itemView);

            news_image=(ImageView) itemView.findViewById(R.id.newsMainImage);
            news_title=(TextView) itemView.findViewById(R.id.newsMainTitle);
            news_short_desc=(TextView) itemView.findViewById(R.id.newsShortDescription);
        }
    }
}
