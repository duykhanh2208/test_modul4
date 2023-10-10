package com.example.test_modul4.repository;

import com.example.test_modul4.model.Classboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassBoardRepository extends JpaRepository<Classboard, Long> {
}
