package com.workintech.S17D3.validation;

import com.workintech.S17D3.entity.Kangaroo;
import com.workintech.S17D3.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooValidation {
    public static void isIdValid(Integer id) throws ZooException {
       if(id == null || id < 0){
           throw new ZooException("id is not valid! ID: " + id, HttpStatus.BAD_REQUEST);
       }
    }

    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangaroos, Integer id, boolean shouldBeExist) {

        if(shouldBeExist){
            if(!kangaroos.containsKey(id)){
                throw new ZooException("Record is not exist with given id:" + id,HttpStatus.NOT_FOUND);
            }
        }
        else{
            if(kangaroos.containsKey(id)){
                throw new ZooException("Record is already exist with given id" + id,HttpStatus.BAD_REQUEST);
            }

        }

    }

    public static void checkWeight(Double weight) {
        if(weight == null || weight <= 0){
            throw new ZooException("weight is not valid! Weight: "+ weight, HttpStatus.BAD_REQUEST);
        }
    }
}
