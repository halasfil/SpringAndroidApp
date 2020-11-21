package com.halasfilip.androidspringclient.utils;

import lombok.Data;

@Data


public class DataResource {

    private String informationSent;

    public DataResource(String informationSent) {
        this.informationSent = informationSent;
    }
}
