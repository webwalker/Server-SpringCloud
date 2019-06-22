package com.xujian.netty.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: xujian.proto")
public final class XujianServiceGrpc {

  private XujianServiceGrpc() {}

  public static final String SERVICE_NAME = "com.xujian.netty.grpc.XujianService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<XujianRequest,
      XujianResponse> getHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hello",
      requestType = XujianRequest.class,
      responseType = XujianResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<XujianRequest,
      XujianResponse> getHelloMethod() {
    io.grpc.MethodDescriptor<XujianRequest, XujianResponse> getHelloMethod;
    if ((getHelloMethod = XujianServiceGrpc.getHelloMethod) == null) {
      synchronized (XujianServiceGrpc.class) {
        if ((getHelloMethod = XujianServiceGrpc.getHelloMethod) == null) {
          XujianServiceGrpc.getHelloMethod = getHelloMethod =
              io.grpc.MethodDescriptor.<XujianRequest, XujianResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.xujian.netty.grpc.XujianService", "hello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  XujianRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  XujianResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new XujianServiceMethodDescriptorSupplier("hello"))
                  .build();
          }
        }
     }
     return getHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static XujianServiceStub newStub(io.grpc.Channel channel) {
    return new XujianServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static XujianServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new XujianServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static XujianServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new XujianServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class XujianServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void hello(XujianRequest request,
                      io.grpc.stub.StreamObserver<XujianResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                XujianRequest,
                XujianResponse>(
                  this, METHODID_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class XujianServiceStub extends io.grpc.stub.AbstractStub<XujianServiceStub> {
    private XujianServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private XujianServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected XujianServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new XujianServiceStub(channel, callOptions);
    }

    /**
     */
    public void hello(XujianRequest request,
                      io.grpc.stub.StreamObserver<XujianResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class XujianServiceBlockingStub extends io.grpc.stub.AbstractStub<XujianServiceBlockingStub> {
    private XujianServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private XujianServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected XujianServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new XujianServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public XujianResponse hello(XujianRequest request) {
      return blockingUnaryCall(
          getChannel(), getHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class XujianServiceFutureStub extends io.grpc.stub.AbstractStub<XujianServiceFutureStub> {
    private XujianServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private XujianServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected XujianServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new XujianServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<XujianResponse> hello(
        XujianRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final XujianServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(XujianServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO:
          serviceImpl.hello((XujianRequest) request,
              (io.grpc.stub.StreamObserver<XujianResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class XujianServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    XujianServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Xujian.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("XujianService");
    }
  }

  private static final class XujianServiceFileDescriptorSupplier
      extends XujianServiceBaseDescriptorSupplier {
    XujianServiceFileDescriptorSupplier() {}
  }

  private static final class XujianServiceMethodDescriptorSupplier
      extends XujianServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    XujianServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (XujianServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new XujianServiceFileDescriptorSupplier())
              .addMethod(getHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
