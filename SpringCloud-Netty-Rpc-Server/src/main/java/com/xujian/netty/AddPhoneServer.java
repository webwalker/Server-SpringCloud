package com.xujian.netty;

import com.xujian.netty.addphone.PhoneServiceImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by xujian on 2019-06-22
 */
public class AddPhoneServer {
    private static final Logger logger = Logger.getLogger(AddPhoneServer.class.getName());

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder
                .forPort(port)
                .addService(new PhoneServiceImp())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        //关闭钩子本质是一个线程（也称为Hook线程），用来监听jvm的关闭。通过Runtime的addShutdownHook可以向JVM注册一个关闭钩子。Hook线程在JVM正常关闭才会执行，强制关闭时不会执行。
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                AddPhoneServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon
     * threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final AddPhoneServer server = new AddPhoneServer();
        server.start();
        server.blockUntilShutdown();
    }
}
