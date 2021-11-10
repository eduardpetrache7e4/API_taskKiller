package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
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

    @Bean
    public void createSomeTasks(){
        
        Task task1=new Task("hacer la comida", LocalDate.of(2020,2,5));
        Task task2=new Task("hacer otra cosa", LocalDate.of(2020,2,5));
        Task task3=new Task("hacer algo con mi vida", LocalDate.of(2020,2,5));
        Task task4=new Task("hacer nada", LocalDate.of(2020,2,5));
        Task task5=new Task("limpiar la cocina", LocalDate.of(2020,2,5));
        Task task6=new Task(" a ", LocalDate.of(2020,2,5));

        List<Task>tasks= Arrays.asList(task1,task2,task3,task4,task5,task6);
        tasks.stream().forEach(taskRepository::save);
    }

}
