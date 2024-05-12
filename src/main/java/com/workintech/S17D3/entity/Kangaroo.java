package com.workintech.S17D3.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Kangaroo {

    private Integer id;
    private String name;
    private Double height;
    private Double weight;
    private String gender;

    private Boolean isAggressive;


}
