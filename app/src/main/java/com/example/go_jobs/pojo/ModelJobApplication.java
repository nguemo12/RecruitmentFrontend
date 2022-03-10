package com.example.go_jobs.pojo;

import java.sql.Timestamp;

public class ModelJobApplication {
    private int jobappid;
    private int applicantid;
    private String jobapptitle;
    private String jobappcv;
    private String jobappletter;
    private Timestamp jobappdate;
    private String jobappdocs;
    private String joboffername;
    private String applicantname;

    public int getJobappid() {
        return jobappid;
    }

    public void setJobappid(int jobappid) {
        this.jobappid = jobappid;
    }

    public int getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(int applicantid) {
        this.applicantid = applicantid;
    }

    public String getJobapptitle() {
        return jobapptitle;
    }

    public void setJobapptitle(String jobapptitle) {
        this.jobapptitle = jobapptitle;
    }

    public String getJobappcv() {
        return jobappcv;
    }

    public void setJobappcv(String jobappcv) {
        this.jobappcv = jobappcv;
    }

    public String getJobappletter() {
        return jobappletter;
    }

    public void setJobappletter(String jobappletter) {
        this.jobappletter = jobappletter;
    }

    public Timestamp getJobappdate() {
        return jobappdate;
    }

    public void setJobappdate(Timestamp jobappdate) {
        this.jobappdate = jobappdate;
    }

    public String getJobappdocs() {
        return jobappdocs;
    }

    public void setJobappdocs(String jobappdocs) {
        this.jobappdocs = jobappdocs;
    }

    public String getJoboffername() {
        return joboffername;
    }

    public void setJoboffername(String joboffername) {
        this.joboffername = joboffername;
    }

    public String getApplicantname() {
        return applicantname;
    }

    public void setApplicantname(String applicantname) {
        this.applicantname = applicantname;
    }
}
