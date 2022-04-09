package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String status;
    private String battery;
    private String location;


}
