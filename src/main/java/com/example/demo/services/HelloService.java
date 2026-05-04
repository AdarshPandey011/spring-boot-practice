package com.example.demo.services;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getMessage() {
        return "Hello from Service layer!";
    }
}