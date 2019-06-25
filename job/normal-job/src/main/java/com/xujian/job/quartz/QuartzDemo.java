package com.xujian.job.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 定义任务类
 */
public class QuartzDemo implements Job {
    @Autowired
    private QuartService service; //需要通过adapterFactory将其注入到Spring Ioc容器中

    /**
     * 任务被触发时所执行的方法
     */
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Execute...." + new Date());
        this.service.addUsers();
    }
}
