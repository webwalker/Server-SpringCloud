package com.xujian.netty.simple;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * Created by xujian on 2019-07-13
 */
public class SerializationProtostuffUtil {
    /**
     * @author wulm
     * @desc protostuff 目前不支持直接序列化List等对象，需要使用普通的POJO包装一下
     */
    private static class SerializeData {
        private Object target;

        public Object getTarget() {
            return target;
        }

        public void setTarget(Object target) {
            this.target = target;
        }
    }

    private static final ThreadLocal<LinkedBuffer> BUFFER_THREAD_LOCAL = ThreadLocal
            .withInitial(() -> LinkedBuffer.allocate());

    @SuppressWarnings("unchecked")
    public static byte[] serialize(Object obj) {
        SerializeData data = new SerializeData();
        data.setTarget(obj);

        // this is lazily created and cached by RuntimeSchema
        // so its safe to call RuntimeSchema.getSchema(Foo.class) over and over
        // The getSchema method is also thread-safe
        Schema<SerializeData> schema = RuntimeSchema.getSchema((Class<SerializeData>) data.getClass());

        // Re-use (manage) this buffer to avoid allocating on every serialization
        // LinkedBuffer buffer = LinkedBuffer.allocate();
        LinkedBuffer buffer = BUFFER_THREAD_LOCAL.get();

        // ser
        try {
            return ProtostuffIOUtil.toByteArray(data, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }

    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] data, Class<T> cls) {
        Schema<SerializeData> schema = RuntimeSchema.getSchema(SerializeData.class);
        // deser
        SerializeData message = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, message, schema);

        return (T) message.getTarget();
    }
}
