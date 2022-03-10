package com.example.go_jobs.pojo;

public class ModelOffer {
    private int jobofferid;
    private int companyid;
    private int applicantid;
    private String offername;
    private String description;
    private String status;
    private String jobofferimage;
    private String jobsalary;
    private String jobtype;

    public ModelOffer() {

    }

    public int getJobofferid() {
        return jobofferid;
    }

    public void setJobofferid(int jobofferid) {
        this.jobofferid = jobofferid;
    }

    public int getCompanyid() {
        return companyid;
    }

    public int getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(int applicantid) {
        this.applicantid = applicantid;
    }

    public String getJobsalary() {
        return jobsalary;
    }

    public void setJobsalary(String jobsalary) {
        this.jobsalary = jobsalary;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobofferimage() {
        return jobofferimage;
    }

    public void setJobofferimage(String jobofferimage) {
        this.jobofferimage = jobofferimage;
    }
}
