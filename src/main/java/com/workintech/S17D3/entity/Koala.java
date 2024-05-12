package com.workintech.S17D3.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Koala {

    private Integer id;
    private String name;
    private Double sleepHour;
    private Double weight;
    private String gender;

}
