package com.example.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zyy on 20/2/16.
 */
public enum IdGenerator {

    INSTANCE;

    private AtomicLong id = new AtomicLong();

    public long getId() {
        return id.incrementAndGet();
    }
}
