package com.example.designpattern.propertycount.version3;

import java.util.List;
import java.util.Map;

/**
 * Created by zyy on 20/2/16.
 */
public abstract class ScheduledReporter {

        protected MetricsStorage metricsStorage;
        protected Aggregator aggregator;
        protected StatViewer viewer;

//    public ScheduledReporter() {
//    }

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis -  startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

}
