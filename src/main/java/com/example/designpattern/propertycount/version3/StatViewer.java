package com.example.designpattern.propertycount.version3;

import java.util.Map;

/**
 * Created by zyy on 20/2/16.
 */
public interface StatViewer {

    void output(Map requestStats, long startTimeInMillis, long endTimeInMills);
}
