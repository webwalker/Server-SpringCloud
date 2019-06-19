package com.xujian.thinking;

import com.xujian.thinking.threads.ITester;
import com.xujian.thinking.threads.WaitNotify;

/**
 * Created by xujian on 2017/3/14.
 */
public class ThreadTest {

    public void go() {
        try {
//            ITester tester = new ThreadJoin();
//            ITester tester = new CountDownLatchTest();
            ITester tester = new WaitNotify();
            tester.Test();
        /*
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
