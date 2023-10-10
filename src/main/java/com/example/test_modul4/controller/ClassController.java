package com.example.test_modul4.controller;

import com.example.test_modul4.model.Classboard;
import com.example.test_modul4.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private IClassService classService;

    @GetMapping("")
    public ResponseEntity<Iterable<Classboard>> showList() {
        Iterable<Classboard> classboards = classService.findAll();
        return new ResponseEntity<>(classboards, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Optional<Classboard>> findOne(@PathVariable("id") Long id) {
        Optional<Classboard> classboard = classService.findById(id);
        if (classboard.isPresent()) {
            return new ResponseEntity<>(classboard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
