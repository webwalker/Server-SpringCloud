// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: xujian.proto

package com.xujian.netty.grpc;

public final class Xujian {
  private Xujian() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xujian_netty_grpc_XujianRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xujian_netty_grpc_XujianRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xujian_netty_grpc_XujianResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xujian_netty_grpc_XujianResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\014xujian.proto\022\025com.xujian.netty.grpc\"4\n" +
      "\rXujianRequest\022\021\n\tfirstName\030\001 \001(\t\022\020\n\010las" +
      "tName\030\002 \001(\t\"\"\n\016XujianResponse\022\020\n\010greetin" +
      "g\030\001 \001(\t2e\n\rXujianService\022T\n\005hello\022$.com." +
      "xujian.netty.grpc.XujianRequest\032%.com.xu" +
      "jian.netty.grpc.XujianResponseB\002P\001b\006prot" +
      "o3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_xujian_netty_grpc_XujianRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_xujian_netty_grpc_XujianRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xujian_netty_grpc_XujianRequest_descriptor,
        new String[] { "FirstName", "LastName", });
    internal_static_com_xujian_netty_grpc_XujianResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_xujian_netty_grpc_XujianResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xujian_netty_grpc_XujianResponse_descriptor,
        new String[] { "Greeting", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
