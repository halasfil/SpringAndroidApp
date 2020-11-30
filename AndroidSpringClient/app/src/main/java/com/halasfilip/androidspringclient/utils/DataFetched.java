package com.halasfilip.androidspringclient.utils;

public class DataFetched {

    private Integer id;
    private String creationTime;
    private String informationSent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getInformationSent() {
        return informationSent;
    }

    public void setInformationSent(String informationSent) {
        this.informationSent = informationSent;
    }

    public DataFetched(Integer id, String creationTime, String informationSent) {
        this.id = id;
        this.creationTime = creationTime;
        this.informationSent = informationSent;
    }
}
