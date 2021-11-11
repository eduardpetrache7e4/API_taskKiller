package com.example.demo.controller;

import com.example.demo.case_use.CreateTask;
import com.example.demo.case_use.DeleteTask;
import com.example.demo.case_use.GetTask;
import com.example.demo.case_use.UpdateTask;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRestController {
    private CreateTask createTask;
    private GetTask getTask;
    private UpdateTask updateTask;
    private DeleteTask deleteTask;
    private TaskRepository taskRepository;


    public TaskRestController(CreateTask createTask,
                              GetTask getTask,
                              UpdateTask updateTask,
                              DeleteTask deleteTask,
                              TaskRepository taskRepository) {
        this.createTask = createTask;
        this.getTask = getTask;
        this.updateTask = updateTask;
        this.deleteTask = deleteTask;
        this.taskRepository=taskRepository;
    }

//getFunciona
//delete Funciona
//post Funciona sin sheet
//put Funciona sin sheeet

    @GetMapping("/")
    List<Task> get(){
        return getTask.getAll();
    }

    @PostMapping("/")
    ResponseEntity<Task> newTask(@RequestBody Task newTask){
        return new ResponseEntity(createTask.save(newTask), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteTask(@PathVariable Long id){
        deleteTask.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<Task>replaceTask(@RequestBody Task newTask, @PathVariable Long id){
        return new ResponseEntity(updateTask.update(newTask,id),HttpStatus.OK);
    }

    @RequestMapping("/prueba")
    @ResponseBody
    public ResponseEntity<String>function(){
        return new ResponseEntity("Hola desde el task controller",HttpStatus.OK);
    }

    @GetMapping("/pageable")
    List<Task> getTaskPageable(@RequestParam int page, @RequestParam int size){ //pageable?page=0&size=2
        return taskRepository.findAll(PageRequest.of(page,size)).getContent();
    }



}
