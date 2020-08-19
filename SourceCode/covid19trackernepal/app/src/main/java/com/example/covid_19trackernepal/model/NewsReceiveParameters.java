package com.example.covid_19trackernepal.model;

import android.graphics.ColorSpace;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.List;

public class NewsReceiveParameters {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends Model implements Serializable {
        /**
         * _id : 5ed65499b2a13336136ecfbb
         * tags : []
         * lang : np
         * url : https://www.onlinekhabar.com/2020/06/869812
         * title : कोरोनाबाट मृत्यु हुनेको परिवारलाई प्रदेश सरकारले एक लाख दिने
         * source : onlinekhabar.com
         * summary : २० जेठ, बुटवल । प्रदेश ५ सरकारले कोरोना संक्रमणबाट मृत्यु हुनेको परिवारलाई एक लाख रुपैयाँ दिने निर्णय गरेको छ । मंगलबार बसेको मन्त्रिपरिषद वैठकले कोरोना संक्रमणबाट मृत्यु हुने व्यक्तिका परिवारलाई एक लाख रुपैयाँ राहतस्वरुप दिने …
         * image_url : https://www.onlinekhabar.com/wp-content/uploads/2019/08/Prov-5-cM-office.jpg
         * created_at : 2020-06-02T13:31:05.647Z
         * updated_at : 2020-06-02T13:31:05.647Z
         * __v : 0
         */

        private String _id;
        private String lang;
        private String url;
        private String title;
        private String source;
        private String summary;
        private String image_url;
        private String created_at;
        private String updated_at;

        private int __v;
        private List<?> tags;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }
    }
}
