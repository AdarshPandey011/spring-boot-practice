package com.example.demo.repository;

import com.example.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    @Query("SELECT s FROM Student s")
    List<Student> findStudents();

    Student findByName(String name);


}
