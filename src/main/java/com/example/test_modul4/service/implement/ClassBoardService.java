package com.example.test_modul4.service.implement;

import com.example.test_modul4.model.Classboard;
import com.example.test_modul4.repository.ClassBoardRepository;
import com.example.test_modul4.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassBoardService implements IClassService {
    @Autowired
    ClassBoardRepository classBoardRepository;

    @Override
    public Iterable<Classboard> findAll() {
        return classBoardRepository.findAll();
    }

    @Override
    public Optional<Classboard> findById(Long id) {
        return classBoardRepository.findById(id);
    }

    @Override
    public void save(Classboard classboard) {
        classBoardRepository.save(classboard);

    }

    @Override
    public void delete(Long id) {
    classBoardRepository.delete(classBoardRepository.findById(id).get());
    }
}
