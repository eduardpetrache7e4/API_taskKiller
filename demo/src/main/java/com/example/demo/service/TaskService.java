package com.example.demo.service;

import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) { //inyectamos el repositorio
        this.taskRepository = taskRepository;
    }
}
