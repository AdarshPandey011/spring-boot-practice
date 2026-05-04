package com.example.demo.controller;

import com.example.demo.services.HelloService;
import com.example.demo.services.Test;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@Validated
@RestController
@RequestMapping("/v1")
public class HelloController {


    @Autowired
    private HelloService helloService;

//    @GetMapping("/hello")
//    public String hello() {
//        return helloService.getMessage();
//    }
    @PostMapping("/hello/{x}")
    public String hello1(@PathVariable String x){
        return x;
    }
//    @PostMapping("/hello")
//    public String hello2(@RequestParam String x){
//        return x;
//    }
    @PostMapping("/hello")
    private ResponseEntity<Test> hello3(@RequestBody @Valid Test t){
//        System.out.println(t);
//        return t;
        return new ResponseEntity<Test>(t, HttpStatus.ACCEPTED);
//        return  ResponseEntity.ok(t);
    }

}