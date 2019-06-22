package com.xujian.netty;

import com.xujian.netty.grpc.XuJianServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Created by xujian on 2019-06-22
 */
public class XuJianServer {
    public static void main(String[] args) {
        try {

            int port = 50051;
            final Server server = ServerBuilder.forPort(port)
                    .addService(new XuJianServiceImpl())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
