package com.xujian.netty.simple;

import lombok.Builder;
import lombok.Data;

/**
 * Created by xujian on 2019-07-13
 */
@Data
@Builder
public class Group {
    private String id;

    private String name;

    private User user;
}
