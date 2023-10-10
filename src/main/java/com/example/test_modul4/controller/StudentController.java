package com.example.test_modul4.controller;

import com.example.test_modul4.model.Student;
import com.example.test_modul4.repository.StudentRepository;
import com.example.test_modul4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Student>> showList() {
        Iterable<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<Student>> findOne(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody Student student) {
        Optional<Student> student1 = studentService.findById(id);
        if (student1.isPresent()) {
            student.setId(student1.get().getId());
            studentService.save(student);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/searchByName")
    public ResponseEntity<List<Student>> search(@RequestBody Student student) {
        String name = student.getName();
        List<Student> students = studentRepository.searchByName("%" + name + "%");
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

}

