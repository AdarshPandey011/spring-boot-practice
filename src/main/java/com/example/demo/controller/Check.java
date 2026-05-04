package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.CheckDto;
import com.example.demo.services.Helper;

import com.example.demo.services.MapDto;
import com.example.demo.services.StudentDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Validated
@RestController
@RequestMapping("v2")
public class Check {
    private Helper hp;
    @Autowired
    StudentRepository StudentRepo;
    public Check(Helper h){
        this.hp = h;
    }

    @PostMapping("/")
    public String fun() {
        return "welcome";
    }

    @GetMapping("/abc/{x}")
    public Integer fun1(@PathVariable @Min(5) Integer x) {
        return x;

    }


    @PostMapping("/add")
    public ResponseEntity<CheckDto> fun(@RequestBody @Valid CheckDto ct) {

        return new ResponseEntity<CheckDto>(ct, HttpStatus.ACCEPTED);

    }

    @PostMapping("/update")
    public MapDto fun3(@Valid @RequestBody MapDto md) {
        System.out.println(md);


        hp.addElements(md.getSno(), md.getName());

        return md;


    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllData(){
        return new ResponseEntity<List<Student>>(hp.getAllData(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/setData")
    public ResponseEntity<String> setData(@RequestBody StudentDto sd){
        Student st = new Student();
        st.setAge(sd.getAge());
        st.setName(sd.getName());
        StudentRepo.save(st);
        return new ResponseEntity<String>("Mydata"+sd, HttpStatus.ACCEPTED);



    }

}