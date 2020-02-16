package com.example.designpattern.propertycount.version2;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by zyy on 20/2/16.
 */
public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson(); System.out.println(gson.toJson(requestStats));
    }
}
