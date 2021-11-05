package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> { //la task y la id


     Optional<Task> findById(Long id);


}
//    private Long id;
//
//    @Column(length = 300)  //nombre de la columna y algunas caracteristicas
//
//    private String content;
//
//    private LocalDate startDate;