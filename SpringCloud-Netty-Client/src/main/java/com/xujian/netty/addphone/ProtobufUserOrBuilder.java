// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addphone.proto

package com.xujian.netty.addphone;

public interface ProtobufUserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:addphone.ProtobufUser)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>string name = 2;</code>
   */
  String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated .addphone.ProtobufUser.Phone phones = 3;</code>
   */
  java.util.List<ProtobufUser.Phone>
      getPhonesList();
  /**
   * <code>repeated .addphone.ProtobufUser.Phone phones = 3;</code>
   */
  ProtobufUser.Phone getPhones(int index);
  /**
   * <code>repeated .addphone.ProtobufUser.Phone phones = 3;</code>
   */
  int getPhonesCount();
  /**
   * <code>repeated .addphone.ProtobufUser.Phone phones = 3;</code>
   */
  java.util.List<? extends ProtobufUser.PhoneOrBuilder>
      getPhonesOrBuilderList();
  /**
   * <code>repeated .addphone.ProtobufUser.Phone phones = 3;</code>
   */
  ProtobufUser.PhoneOrBuilder getPhonesOrBuilder(
          int index);
}