package com.example.designpattern.propertycount.version1;

import lombok.Data;

/**
 * Created by zyy on 20/2/15.
 */

@Data
public class RequestInfo {

    public RequestInfo(String apiName, double responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    private String apiName;
    private double responseTime;
    private long timestamp;
}
