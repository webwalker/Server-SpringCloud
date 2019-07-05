package com.xujian.rocketmq.exception;

/**
 * Created by xujian on 2019-07-03
 */
public class RocketMQException extends Throwable {
    public RocketMQException() {
    }

    public RocketMQException(String message) {
        super(message);
    }

    public RocketMQException(String message, Throwable cause) {
        super(message, cause);
    }

    public RocketMQException(Throwable cause) {
        super(cause);
    }

    public RocketMQException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
