package com.example.demo.case_use;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

import java.util.List;

public class GetTaskImplement implements GetTask{

    private TaskService taskService;

    public GetTaskImplement(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public List<Task> getAll() { return taskService.getAllTasks();}

}