package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Implements {
    private int id;
    private Date datetime;
    private String temp;
    private String hum;
    private String lux;
    private String pm25;
    private String pm10;
    private String windD;
    private String windV;
}
