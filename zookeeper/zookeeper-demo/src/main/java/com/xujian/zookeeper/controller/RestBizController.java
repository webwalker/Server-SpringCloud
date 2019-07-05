package com.xujian.zookeeper.controller;

import com.xujian.zookeeper.ZooKeeperProSync;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xujian on 2019-06-30
 */
@RestController
public class RestBizController {

    @RequestMapping(value = "/zkget", method = RequestMethod.GET)
    public String zkget() {
        Watcher watcher = event -> System.out.println("receive event：" + event);

        String value = null;
        try {
            final ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181", 999999, watcher);
            final byte[] data = zookeeper.getData("/node_1", watcher, null);
            value = new String(data);
            zookeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "get value from zookeeper [" + value + "]";
    }

    @RequestMapping(value = "/zkget2", method = RequestMethod.GET)
    public String zkget2() {
        System.out.println("正在监听配置值修改.");
        ZooKeeperProSync watcher = new ZooKeeperProSync();
        try {
            watcher.get2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listening...";
    }
}
