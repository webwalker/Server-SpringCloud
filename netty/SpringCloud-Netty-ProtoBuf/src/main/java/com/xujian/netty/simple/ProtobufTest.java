package com.xujian.netty.simple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by xujian on 2019-07-01
 */
@Component
public class ProtobufTest implements CommandLineRunner {

    /**
     * 直接通过protosbuff完成序列化、反序列化，不需要写.proto文件
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        //创建一个user对象
        User user = User.builder().id("1").age(20).name("张三").desc("programmer").build();

        //创建一个Group对象
        Group group = Group.builder().id("1").name("分组1").user(user).build();

        //使用ProtostuffUtils序列化
        byte[] data = ProtostuffUtils.serialize(group);
        System.out.println("序列化后：" + Arrays.toString(data));

        Group result = ProtostuffUtils.deserialize(data, Group.class);
        System.out.println("反序列化后：" + result.toString());
    }
}
