package com.xujian.netty.grpc;

import io.grpc.stub.StreamObserver;

/**
 * Created by xujian on 2019-06-22
 */
public class XuJianServiceImpl extends XujianServiceGrpc.XujianServiceImplBase {

    @Override
    public void hello(
            XujianRequest request, StreamObserver<XujianResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        XujianResponse response = XujianResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
