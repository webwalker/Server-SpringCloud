// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addphone.proto

package com.xujian.netty.addphone;

public final class addphoneProto {
  private addphoneProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_addphone_ProtobufUser_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_addphone_ProtobufUser_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_addphone_ProtobufUser_Phone_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_addphone_ProtobufUser_Phone_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_addphone_AddPhoneToUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_addphone_AddPhoneToUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_addphone_AddPhoneToUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_addphone_AddPhoneToUserResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016addphone.proto\022\010addphone\"\234\001\n\014ProtobufU" +
      "ser\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022,\n\006phones\030" +
      "\003 \003(\0132\034.addphone.ProtobufUser.Phone\032D\n\005P" +
      "hone\022&\n\tphoneType\030\001 \001(\0162\023.addphone.Phone" +
      "Type\022\023\n\013phoneNumber\030\002 \001(\t\"a\n\025AddPhoneToU" +
      "serRequest\022\013\n\003uid\030\001 \001(\005\022&\n\tphoneType\030\002 \001" +
      "(\0162\023.addphone.PhoneType\022\023\n\013phoneNumber\030\003" +
      " \001(\t\"(\n\026AddPhoneToUserResponse\022\016\n\006result" +
      "\030\001 \001(\010**\n\tPhoneType\022\010\n\004HOME\020\000\022\010\n\004WORK\020\001\022" +
      "\t\n\005OTHER\020\0022c\n\014PhoneService\022S\n\016addPhoneTo" +
      "User\022\037.addphone.AddPhoneToUserRequest\032 ." +
      "addphone.AddPhoneToUserResponseB,\n\031com.x" +
      "ujian.netty.addphoneB\raddphoneProtoP\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_addphone_ProtobufUser_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_addphone_ProtobufUser_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_addphone_ProtobufUser_descriptor,
        new String[] { "Id", "Name", "Phones", });
    internal_static_addphone_ProtobufUser_Phone_descriptor =
      internal_static_addphone_ProtobufUser_descriptor.getNestedTypes().get(0);
    internal_static_addphone_ProtobufUser_Phone_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_addphone_ProtobufUser_Phone_descriptor,
        new String[] { "PhoneType", "PhoneNumber", });
    internal_static_addphone_AddPhoneToUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_addphone_AddPhoneToUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_addphone_AddPhoneToUserRequest_descriptor,
        new String[] { "Uid", "PhoneType", "PhoneNumber", });
    internal_static_addphone_AddPhoneToUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_addphone_AddPhoneToUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_addphone_AddPhoneToUserResponse_descriptor,
        new String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}