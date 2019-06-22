// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: addphone.proto

package com.xujian.netty.addphone;

/**
 * Protobuf type {@code addphone.AddPhoneToUserRequest}
 */
public  final class AddPhoneToUserRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:addphone.AddPhoneToUserRequest)
    AddPhoneToUserRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AddPhoneToUserRequest.newBuilder() to construct.
  private AddPhoneToUserRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddPhoneToUserRequest() {
    phoneType_ = 0;
    phoneNumber_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new AddPhoneToUserRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AddPhoneToUserRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            uid_ = input.readInt32();
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            phoneType_ = rawValue;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            phoneNumber_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return addphoneProto.internal_static_addphone_AddPhoneToUserRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return addphoneProto.internal_static_addphone_AddPhoneToUserRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            AddPhoneToUserRequest.class, AddPhoneToUserRequest.Builder.class);
  }

  public static final int UID_FIELD_NUMBER = 1;
  private int uid_;
  /**
   * <code>int32 uid = 1;</code>
   */
  public int getUid() {
    return uid_;
  }

  public static final int PHONETYPE_FIELD_NUMBER = 2;
  private int phoneType_;
  /**
   * <code>.addphone.PhoneType phoneType = 2;</code>
   */
  public int getPhoneTypeValue() {
    return phoneType_;
  }
  /**
   * <code>.addphone.PhoneType phoneType = 2;</code>
   */
  public PhoneType getPhoneType() {
    @SuppressWarnings("deprecation")
    PhoneType result = PhoneType.valueOf(phoneType_);
    return result == null ? PhoneType.UNRECOGNIZED : result;
  }

  public static final int PHONENUMBER_FIELD_NUMBER = 3;
  private volatile Object phoneNumber_;
  /**
   * <code>string phoneNumber = 3;</code>
   */
  public String getPhoneNumber() {
    Object ref = phoneNumber_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      phoneNumber_ = s;
      return s;
    }
  }
  /**
   * <code>string phoneNumber = 3;</code>
   */
  public com.google.protobuf.ByteString
      getPhoneNumberBytes() {
    Object ref = phoneNumber_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      phoneNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (uid_ != 0) {
      output.writeInt32(1, uid_);
    }
    if (phoneType_ != PhoneType.HOME.getNumber()) {
      output.writeEnum(2, phoneType_);
    }
    if (!getPhoneNumberBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, phoneNumber_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (uid_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, uid_);
    }
    if (phoneType_ != PhoneType.HOME.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, phoneType_);
    }
    if (!getPhoneNumberBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, phoneNumber_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof AddPhoneToUserRequest)) {
      return super.equals(obj);
    }
    AddPhoneToUserRequest other = (AddPhoneToUserRequest) obj;

    if (getUid()
        != other.getUid()) return false;
    if (phoneType_ != other.phoneType_) return false;
    if (!getPhoneNumber()
        .equals(other.getPhoneNumber())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + UID_FIELD_NUMBER;
    hash = (53 * hash) + getUid();
    hash = (37 * hash) + PHONETYPE_FIELD_NUMBER;
    hash = (53 * hash) + phoneType_;
    hash = (37 * hash) + PHONENUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getPhoneNumber().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static AddPhoneToUserRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AddPhoneToUserRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AddPhoneToUserRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AddPhoneToUserRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AddPhoneToUserRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AddPhoneToUserRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AddPhoneToUserRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AddPhoneToUserRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static AddPhoneToUserRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static AddPhoneToUserRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static AddPhoneToUserRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AddPhoneToUserRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(AddPhoneToUserRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code addphone.AddPhoneToUserRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:addphone.AddPhoneToUserRequest)
      AddPhoneToUserRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return addphoneProto.internal_static_addphone_AddPhoneToUserRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return addphoneProto.internal_static_addphone_AddPhoneToUserRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AddPhoneToUserRequest.class, AddPhoneToUserRequest.Builder.class);
    }

    // Construct using com.xujian.netty.addphone.AddPhoneToUserRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      uid_ = 0;

      phoneType_ = 0;

      phoneNumber_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return addphoneProto.internal_static_addphone_AddPhoneToUserRequest_descriptor;
    }

    @Override
    public AddPhoneToUserRequest getDefaultInstanceForType() {
      return AddPhoneToUserRequest.getDefaultInstance();
    }

    @Override
    public AddPhoneToUserRequest build() {
      AddPhoneToUserRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public AddPhoneToUserRequest buildPartial() {
      AddPhoneToUserRequest result = new AddPhoneToUserRequest(this);
      result.uid_ = uid_;
      result.phoneType_ = phoneType_;
      result.phoneNumber_ = phoneNumber_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof AddPhoneToUserRequest) {
        return mergeFrom((AddPhoneToUserRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(AddPhoneToUserRequest other) {
      if (other == AddPhoneToUserRequest.getDefaultInstance()) return this;
      if (other.getUid() != 0) {
        setUid(other.getUid());
      }
      if (other.phoneType_ != 0) {
        setPhoneTypeValue(other.getPhoneTypeValue());
      }
      if (!other.getPhoneNumber().isEmpty()) {
        phoneNumber_ = other.phoneNumber_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      AddPhoneToUserRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (AddPhoneToUserRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int uid_ ;
    /**
     * <code>int32 uid = 1;</code>
     */
    public int getUid() {
      return uid_;
    }
    /**
     * <code>int32 uid = 1;</code>
     */
    public Builder setUid(int value) {

      uid_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 uid = 1;</code>
     */
    public Builder clearUid() {

      uid_ = 0;
      onChanged();
      return this;
    }

    private int phoneType_ = 0;
    /**
     * <code>.addphone.PhoneType phoneType = 2;</code>
     */
    public int getPhoneTypeValue() {
      return phoneType_;
    }
    /**
     * <code>.addphone.PhoneType phoneType = 2;</code>
     */
    public Builder setPhoneTypeValue(int value) {
      phoneType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.addphone.PhoneType phoneType = 2;</code>
     */
    public PhoneType getPhoneType() {
      @SuppressWarnings("deprecation")
      PhoneType result = PhoneType.valueOf(phoneType_);
      return result == null ? PhoneType.UNRECOGNIZED : result;
    }
    /**
     * <code>.addphone.PhoneType phoneType = 2;</code>
     */
    public Builder setPhoneType(PhoneType value) {
      if (value == null) {
        throw new NullPointerException();
      }

      phoneType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.addphone.PhoneType phoneType = 2;</code>
     */
    public Builder clearPhoneType() {

      phoneType_ = 0;
      onChanged();
      return this;
    }

    private Object phoneNumber_ = "";
    /**
     * <code>string phoneNumber = 3;</code>
     */
    public String getPhoneNumber() {
      Object ref = phoneNumber_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        phoneNumber_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string phoneNumber = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPhoneNumberBytes() {
      Object ref = phoneNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        phoneNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string phoneNumber = 3;</code>
     */
    public Builder setPhoneNumber(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      phoneNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string phoneNumber = 3;</code>
     */
    public Builder clearPhoneNumber() {

      phoneNumber_ = getDefaultInstance().getPhoneNumber();
      onChanged();
      return this;
    }
    /**
     * <code>string phoneNumber = 3;</code>
     */
    public Builder setPhoneNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      phoneNumber_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:addphone.AddPhoneToUserRequest)
  }

  // @@protoc_insertion_point(class_scope:addphone.AddPhoneToUserRequest)
  private static final AddPhoneToUserRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AddPhoneToUserRequest();
  }

  public static AddPhoneToUserRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddPhoneToUserRequest>
      PARSER = new com.google.protobuf.AbstractParser<AddPhoneToUserRequest>() {
    @Override
    public AddPhoneToUserRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AddPhoneToUserRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddPhoneToUserRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AddPhoneToUserRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public AddPhoneToUserRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

