package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Coffee;
import com.example.demo.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/auth")
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @CrossOrigin
    @PostMapping("/coffee")
    public Coffee createCoffee(@Validated @RequestBody Coffee coffee){
        Coffee coffee1 = coffeeRepository.save(coffee);
        return coffee1;
    }
    @CrossOrigin
    @GetMapping("/coffee")
    public Page<Coffee> listCoffees(Pageable pageable){
        return coffeeRepository.findAll(pageable);
    }
    @CrossOrigin
    @GetMapping("/coffee/{id}")
    public  Coffee getById(@PathVariable Long id){
        Coffee coffee = coffeeRepository.getById(id);
        return coffee;
    }
    @CrossOrigin
    @DeleteMapping("/coffee/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        return coffeeRepository.findById(id).map(coffee -> {
            coffeeRepository.delete(coffee);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Coffee not found with id" + id));
        }
    }

