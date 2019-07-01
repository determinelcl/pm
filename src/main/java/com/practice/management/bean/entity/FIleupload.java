package com.practice.management.bean.entity;

/*
* 文件上传
* */
public class FIleupload {
    private int id;
    private String spendUrl;
    private String trainProgramme;
    private String trainSummary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpendUrl() {
        return spendUrl;
    }

    public void setSpendUrl(String spendUrl) {
        this.spendUrl = spendUrl;
    }

    public String getTrainProgramme() {
        return trainProgramme;
    }

    public void setTrainProgramme(String trainProgramme) {
        this.trainProgramme = trainProgramme;
    }

    public String getTrainSummary() {
        return trainSummary;
    }

    public void setTrainSummary(String trainSummary) {
        this.trainSummary = trainSummary;
    }
}
