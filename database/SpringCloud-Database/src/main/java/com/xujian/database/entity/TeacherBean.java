package com.xujian.database.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TeacherBean {
    private String tecId;

    private String tecName;

    private int tecAge;

    private String tecDesc;
}
