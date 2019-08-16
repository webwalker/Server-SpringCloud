package com.xujian.netty;

import com.xujian.netty.grpc.XujianRequest;
import com.xujian.netty.grpc.XujianResponse;
import com.xujian.netty.grpc.XujianServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by xujian on 2019-06-22
 */
public class XuJianClient {
    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext(true).build();

            XujianServiceGrpc.XujianServiceBlockingStub stub = XujianServiceGrpc.newBlockingStub(channel);

            XujianResponse helloResponse = stub
                    .hello(XujianRequest.newBuilder().setFirstName("Baeldung").setLastName("gRPC").build());

            System.out.println(helloResponse.getGreeting());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
