package com.example.covid_19trackernepal.model;

public class NepalCovidUpdatesReceiveParameters {

    /**
     * tested_positive : 2300
     * tested_negative : 77967
     * tested_total : 80267
     * in_isolation : 2013
     * quarantined : 155868
     * tested_rdt : 120379
     * pending_result : 0
     * recovered : 278
     * deaths : 9
     * source : https://drive.google.com/file/d/10t0g25TYlXTuV_wqUPazFFJobAJVSsxs/view
     * updated_at : 2020-06-03T00:00:00.000Z
     * latest_sit_report : {"type":"MOHP","_id":"5ed653fcb2a13336136ecfb8","no":114,"date":"2020-06-02","url":"https://drive.google.com/file/d/10t0g25TYlXTuV_wqUPazFFJobAJVSsxs/view","created_at":"2020-06-02T13:28:28.542Z","updated_at":"2020-06-02T13:28:28.542Z","__v":0}
     */

    private int tested_positive;
    private int tested_negative;
    private int tested_total;
    private int in_isolation;
    private int quarantined;
    private int tested_rdt;
    private int pending_result;
    private int recovered;
    private int deaths;
    private String source;
    private String updated_at;
    private LatestSitReportBean latest_sit_report;

    public int getTested_positive() {
        return tested_positive;
    }

    public void setTested_positive(int tested_positive) {
        this.tested_positive = tested_positive;
    }

    public int getTested_negative() {
        return tested_negative;
    }

    public void setTested_negative(int tested_negative) {
        this.tested_negative = tested_negative;
    }

    public int getTested_total() {
        return tested_total;
    }

    public void setTested_total(int tested_total) {
        this.tested_total = tested_total;
    }

    public int getIn_isolation() {
        return in_isolation;
    }

    public void setIn_isolation(int in_isolation) {
        this.in_isolation = in_isolation;
    }

    public int getQuarantined() {
        return quarantined;
    }

    public void setQuarantined(int quarantined) {
        this.quarantined = quarantined;
    }

    public int getTested_rdt() {
        return tested_rdt;
    }

    public void setTested_rdt(int tested_rdt) {
        this.tested_rdt = tested_rdt;
    }

    public int getPending_result() {
        return pending_result;
    }

    public void setPending_result(int pending_result) {
        this.pending_result = pending_result;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public LatestSitReportBean getLatest_sit_report() {
        return latest_sit_report;
    }

    public void setLatest_sit_report(LatestSitReportBean latest_sit_report) {
        this.latest_sit_report = latest_sit_report;
    }

    public static class LatestSitReportBean {
        /**
         * type : MOHP
         * _id : 5ed653fcb2a13336136ecfb8
         * no : 114
         * date : 2020-06-02
         * url : https://drive.google.com/file/d/10t0g25TYlXTuV_wqUPazFFJobAJVSsxs/view
         * created_at : 2020-06-02T13:28:28.542Z
         * updated_at : 2020-06-02T13:28:28.542Z
         * __v : 0
         */

        private String type;
        private String _id;
        private int no;
        private String date;
        private String url;
        private String created_at;
        private String updated_at;
        private int __v;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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
    }
}
