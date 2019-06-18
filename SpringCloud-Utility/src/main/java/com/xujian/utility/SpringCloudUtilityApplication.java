package com.xujian.utility;

import com.xujian.utility.async.AsyncTaskService;
import com.xujian.utility.test.TestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.xujian.utility.async") //异步方法所在的包, 暂时不用这个了
public class SpringCloudUtilityApplication {
    @Autowired
    AsyncTaskService task; //static无法用

    public static void main(String[] args) throws Exception {
        System.out.println("start");

        TestHelper.test();

        System.out.println("end.");
    }
}
