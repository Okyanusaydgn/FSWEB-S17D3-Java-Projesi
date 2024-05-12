package com.workintech.S17D3.controller;


import com.workintech.S17D3.entity.Kangaroo;
import com.workintech.S17D3.exceptions.ZooException;
import com.workintech.S17D3.validation.ZooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;


    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
        kangaroos.put(1,new Kangaroo(1,"kangaroo",200d,100d,"female",true));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Kangaroo> findAll(){
        return this.kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo find(@PathVariable Integer id) throws ZooException {

        ZooValidation.isIdValid(id);
        ZooValidation.checkKangarooExistence(kangaroos,id,true);
        return kangaroos.get(id);
    }

    @PostMapping
    public Kangaroo save(@RequestBody Kangaroo kangaroo){
        ZooValidation.isIdValid(kangaroo.getId());
        ZooValidation.checkKangarooExistence(kangaroos, kangaroo.getId(), false);
        ZooValidation.checkWeight(kangaroo.getWeight());
        kangaroos.put(kangaroo.getId(),kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable Integer id, @RequestBody Kangaroo kangaroo){
        ZooValidation.isIdValid(id);
        ZooValidation.checkWeight(kangaroo.getWeight());
        kangaroo.setId(id);
        if (kangaroos.containsKey(id)){
            kangaroos.put(id,kangaroo);
            return kangaroos.get(id);
        }
        else{
            return save(kangaroo);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        ZooValidation.isIdValid(id);
        ZooValidation.checkKangarooExistence(kangaroos,id,true);
        kangaroos.remove(id);
    }
}
