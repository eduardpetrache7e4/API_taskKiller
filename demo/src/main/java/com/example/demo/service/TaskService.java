package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) { //inyectamos el repositorio
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task save(Task newTask) {
        return taskRepository.save(newTask);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task update(Task newTask, Long id) {
        return
                taskRepository.findById(id)
                        .map(
                                task->{
                                    task.setContent(newTask.getContent());
                                    task.setStartDate(newTask.getStartDate());

                                    return taskRepository.save(task);
                                }
                        ).get();

    }



}
