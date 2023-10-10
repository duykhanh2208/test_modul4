package com.example.test_modul4.repository;

import com.example.test_modul4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select * from student where name like :name ", nativeQuery = true)
    List<Student> searchByName(@Param("name")String name);
}
