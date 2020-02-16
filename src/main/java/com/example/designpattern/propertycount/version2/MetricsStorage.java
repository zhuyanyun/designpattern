package com.example.designpattern.propertycount.version2;

import java.util.List;
import java.util.Map;

/**
 * Created by zyy on 20/2/15.
 */
public interface MetricsStorage {

    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);

}
