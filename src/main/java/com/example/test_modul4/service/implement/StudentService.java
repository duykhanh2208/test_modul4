package com.example.test_modul4.service.implement;

import com.example.test_modul4.model.Student;
import com.example.test_modul4.repository.StudentRepository;
import com.example.test_modul4.service.IClassService;
import com.example.test_modul4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(studentRepository.findById(id).get());

    }
}
