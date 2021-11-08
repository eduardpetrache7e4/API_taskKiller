package com.example.demo;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TaskKillerAPI  {//implements CommandLineRunner

    private TaskRepository taskRepository;
    private TaskService taskService;



    public static void main(String[] args) {
        SpringApplication.run(TaskKillerAPI.class, args);
    }

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


//    @Override
//    public void run(String... args) throws RuntimeException {
//
//            createSomeTasks();
//
//    }
}
