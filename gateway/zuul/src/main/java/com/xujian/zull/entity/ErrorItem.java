package com.xujian.zull.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xujian on 2019-07-06
 */
@AllArgsConstructor
@Data
public class ErrorItem implements Serializable {
    private int code;
    private String msg;
}
