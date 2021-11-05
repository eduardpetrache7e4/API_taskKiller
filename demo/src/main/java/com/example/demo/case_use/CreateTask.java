package com.example.demo.case_use;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Component;

@Component
public class CreateTask {
    private TaskService taskService;

    public CreateTask(TaskService taskService){
        this.taskService=taskService;
    }


    public Object save(Task newTask) {
        return taskService.save(newTask);
    }
}
