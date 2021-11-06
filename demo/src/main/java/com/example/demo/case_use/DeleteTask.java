package com.example.demo.case_use;

import com.example.demo.service.TaskService;
import org.springframework.stereotype.Component;

@Component
public class DeleteTask {

    private TaskService taskService;

    public DeleteTask(TaskService taskService){
        this.taskService=taskService;
    }


    public void remove(Long id) {
        taskService.delete(id);
    }
}
