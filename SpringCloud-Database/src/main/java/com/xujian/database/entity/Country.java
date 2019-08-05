package com.xujian.database.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xujian on 2019-08-04
 */
@Data
public class Country implements Serializable {
    private static final long serialVersionUID = 6569081236403751407L;

    private int    id;
    private String countryname;
    private String countrycode;

    //总数
    private int count;
}
