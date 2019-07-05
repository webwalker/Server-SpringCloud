package com.xujian.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xujian on 2019-06-30
 */
public class ZooKeeperProSync implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    public void get2() throws Exception {
        //Zookeeper配置数据存放路径
        String path = "/node_2";
        //连接Zookeeper并且注册一个默认的监听器，注明服务器的IP和端口
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new ZooKeeperProSync());

        //等待zk连接成功的通知
        connectedSemaphore.await();
        //获取path目录节点的配置数据，并注册默认的监听器
        System.out.println(new String(zk.getData(path, true, stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }

    //set /node_2 mydata 变化之后，这里会调用
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {    //zk连接成功通知事件
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {    //zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改，新值为：" +
                            new String(zk.getData(event.getPath(), true, stat)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {

        }
    }
}
