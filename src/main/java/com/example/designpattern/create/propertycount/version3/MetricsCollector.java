package com.example.designpattern.create.propertycount.version3;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.springframework.util.StringUtils;

import java.util.concurrent.Executors;

/**
 * Created by zyy on 20/2/15.
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage;//基于接口而非实现编程
    private EventBus eventBus;

    // 兼顾代码的易用性，新增一个封装了默认依赖的构造函数
    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    //用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isEmpty(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }

}
