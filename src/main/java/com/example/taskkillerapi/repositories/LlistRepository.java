package com.example.taskkillerapi.repositories;

import com.example.taskkillerapi.entities.Llist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LlistRepository extends CrudRepository<Llist, Long> {

    Optional<Llist> findById(Long id);

}