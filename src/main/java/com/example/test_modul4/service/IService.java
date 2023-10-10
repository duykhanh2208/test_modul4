package com.example.test_modul4.service;

import java.util.List;
import java.util.Optional;

public interface IService<E> {
    public Iterable<E> findAll();

    public Optional<E> findById(Long id);

    public void save(E e);

    public void delete(Long id);
}