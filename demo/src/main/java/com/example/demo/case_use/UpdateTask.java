package com.example.demo.case_use;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Component;

@Component
public class UpdateTask {
    private TaskService taskService;

    public UpdateTask(TaskService taskService){
        this.taskService=taskService;
    }


    public Task update(Task newtask, Long id) {
        return taskService.update(newtask,id);
    }

}
