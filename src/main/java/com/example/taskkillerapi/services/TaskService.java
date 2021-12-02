package com.example.taskkillerapi.services;


import com.example.taskkillerapi.entities.Llist;
import com.example.taskkillerapi.entities.Task;
import com.example.taskkillerapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public ArrayList<Task> getTasks() {
        return (ArrayList<Task>) taskRepository.findAll();
    }
    
    public ArrayList<Task> getTaskByList(Long id) { //devuelve las tareas pertenecientes a una lista, el id es de la lista
         ArrayList<Task>listTasks=new ArrayList<>();
         taskRepository.findAll().forEach(task->
                 {
                     if (task.getList().getId() == id) {
                        listTasks.add(task);
                     }
                 }
                );
         return listTasks;
    }

        public Task saveTask (Task task){
            return taskRepository.save(task);
        }

        public Optional<Task> findById (Long id){
            return taskRepository.findById(id);
        }

        public boolean deleteTask (Long id){ //esta dentro de una funcion boolean porque asi si falla
            try {                          // no fallara el programa
                taskRepository.deleteById(id);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

        public Task updateContent (Task newTask, Long id){
            return taskRepository.findById(id)
                            .map(
                                    task -> {
                                        task.setContent(newTask.getContent());
                                        return taskRepository.save(task);
                                    }
                            ).get();
        }


    public Task checkTask(Boolean done, Long id) {
         return taskRepository.findById(id)
                .map(
                        task -> {
                            task.setDone(done);
                            return taskRepository.save(task);
                        }
                ).get();
    }

    public Task updateTaskContent(String newContent, Long id) {
        return taskRepository.findById(id)
                .map(
                        task -> {
                            task.setContent(newContent);
                            return taskRepository.save(task);
                        }
                ).get();
    }
}


