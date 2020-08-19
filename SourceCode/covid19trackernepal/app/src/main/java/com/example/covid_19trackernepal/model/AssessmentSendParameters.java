package com.example.covid_19trackernepal.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Assessment")
public class AssessmentSendParameters extends Model {

    @Column(name = "Age")
    public String age;

    @Column(name = "Gender")
    public String gender;

    @Column(name = "Temperature")
    public String temperature;

    @Column(name = "Cough")
    public String cough;

    @Column(name = "MusclesAches")
    public String aches;

    @Column(name = "SoreThroat")
    public String sorethroat;

    @Column(name = "Diarrhea")
    public String diarrhea;

    @Column(name = "Headache")
    public String headache;

    @Column(name = "BreathShortness")
    public String breath;

    @Column(name = "FromAbroad")
    public String abroad;

    @Column(name = "ContactwithCovidperson")
    public String contact;

    @Column(name = "SelfQuarantine")
    public String quarantine;

    @Column(name = "Result")
    public String result;
}
