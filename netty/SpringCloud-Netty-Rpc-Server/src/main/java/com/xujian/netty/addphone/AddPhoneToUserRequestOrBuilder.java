// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addphone.proto

package com.xujian.netty.addphone;

public interface AddPhoneToUserRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:addphone.AddPhoneToUserRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 uid = 1;</code>
   */
  int getUid();

  /**
   * <code>.addphone.PhoneType phoneType = 2;</code>
   */
  int getPhoneTypeValue();
  /**
   * <code>.addphone.PhoneType phoneType = 2;</code>
   */
  PhoneType getPhoneType();

  /**
   * <code>string phoneNumber = 3;</code>
   */
  String getPhoneNumber();
  /**
   * <code>string phoneNumber = 3;</code>
   */
  com.google.protobuf.ByteString
      getPhoneNumberBytes();
}
