package com.example.designpattern.create.propertycount.version3;

import com.google.common.annotations.VisibleForTesting;

import java.util.*;

/**
 * Created by zyy on 20/2/16.
 */
public class EmailReporter extends ScheduledReporter {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;

//    public EmailReporter() {}

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public EmailReporter(List emailToAddresses) {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer(emailToAddresses));
    }

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage,aggregator,viewer);
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    public void startDailyReport() {
        // new Date()可以获取当前时间
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    // 设置成protected而非private是为了方便写单元测试
    @VisibleForTesting
    protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();// 这里可以获取当前时间
        calendar.setTime(date); // 重新设置时间
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

//    public static void main(String[] args) {
//        EmailReporter emailReporter = new EmailReporter();
//        System.out.println(emailReporter.trimTimeFieldsToZeroOfNextDay(null));
//    }
//

}
