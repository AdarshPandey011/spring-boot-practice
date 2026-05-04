package com.example.demo.services;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entity.Student;
import java.util.List;

@Service
public class Helper {
    
    @Autowired
    private StudentRepository studentRepo;      
            
            
    Map<Integer, String> map = new HashMap<>();
     void Helper() {
         map.put(1,"adarsh");
    }

    public void addElements(int sno,String str){
         map.put(sno,str);
         map.values().stream().forEach(System.out::println);

     }

//    public void deleteElement(int sno){
//         map.remove(sno);
//    }
    public List<Student> getAllData(){
         
         List<Student> lst = studentRepo.findStudents();
         return lst;
         
    }
    

}
