package com.example.designpattern.propertycount.version1;

import lombok.Data;

/**
 * Created by zyy on 20/2/15.
 */

@Data
public class RequestStat {

    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;
    //...省略getter/setter方法...
}
