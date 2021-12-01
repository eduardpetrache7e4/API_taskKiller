package com.example.taskkillerapi.controllers;

import com.example.taskkillerapi.entities.Llist;
import com.example.taskkillerapi.entities.Task;
import com.example.taskkillerapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping()  //http://localhost:8081/api/tasks/
    public ArrayList<Task>getUsers(){
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getUsersById(@PathVariable("id") Long id){
        return taskService.findById(id);
    }

    @GetMapping("/list/{id}/task")
    public ArrayList<Task> getTaskByList(@PathVariable("id") Long id){
        return taskService.getTaskByList(id);
    }



    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return this.taskService.saveTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task newTask, @PathVariable Long id){
       return this.taskService.updateContent(newTask, id);
    }

    @PutMapping("/{id}/done")
    public Task checkTask(@RequestBody Boolean done, @PathVariable Long id){
        return this.taskService.checkTask(done, id);
    }

    @PutMapping("/{id}/content")
    public Task updateTaskContent(@RequestBody String newContent, @PathVariable Long id){
        return this.taskService.updateTaskContent(newContent, id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean result=this.taskService.deleteTask(id);
        if (result){
            return "Se elimino la tarea";
        }else {
            return "No se pudo eliminar la tarea";
        }
    }

    @RequestMapping("/prueba")
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity("Hola desde el task controller", HttpStatus.OK);
    }

}
