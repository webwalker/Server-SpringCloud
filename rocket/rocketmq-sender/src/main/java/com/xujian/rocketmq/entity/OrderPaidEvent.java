package com.xujian.rocketmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by xujian on 2019-07-01
 */
@Data
@AllArgsConstructor
public class OrderPaidEvent implements Serializable {
    private String orderId;

    private BigDecimal paidMoney;
}