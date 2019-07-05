package com.xujian.utility.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xujian on 2019-07-02
 */
@Component
public class TestUtil {
    private CountDownLatch latch = new CountDownLatch(1);

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void countdown() {
        latch.countDown();
    }

    public void print() {
        System.out.println("datetime: " + System.currentTimeMillis());
    }
}
