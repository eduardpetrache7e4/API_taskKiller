package com.example.demo;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TaskKillerAPI{//implements CommandLineRunner

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;



    public static void main(String[] args) {
        SpringApplication.run(TaskKillerAPI.class, args);
    }



}
