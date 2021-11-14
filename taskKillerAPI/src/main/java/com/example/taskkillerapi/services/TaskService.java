package com.example.taskkillerapi.services;


import com.example.taskkillerapi.entities.Task;
import com.example.taskkillerapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired //
    TaskRepository taskRepository;

    public ArrayList<Task>getTasks(){
       return(ArrayList<Task>) taskRepository.findAll();
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task>findById(Long id){
        return taskRepository.findById(id);
    }

    public boolean deleteTask(Long id){ //esta dentro de una funcion boolean porque asi si falla
        try {                          // no fallara el programa
            taskRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public Task updateContent(Task newTask, Long id) {
        return
                taskRepository.findById(id)
                        .map(
                                task->{
                                    task.setContent(newTask.getContent());
                                    return taskRepository.save(task);
                                }
                        ).get();

    }

}

