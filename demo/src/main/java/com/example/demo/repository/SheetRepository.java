package com.example.demo.repository;

import com.example.demo.entity.Sheet;
import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SheetRepository extends JpaRepository<Sheet,Long> { //la task y la id


    Optional<Sheet> findById(Long id);
}
