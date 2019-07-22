package com.xujian.apollo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by xujian on 2019-07-22
 */
@AllArgsConstructor
@Data
public class ConfigBean<T> {
    private String key;
    private String defaultValue;
    private String description;
}
