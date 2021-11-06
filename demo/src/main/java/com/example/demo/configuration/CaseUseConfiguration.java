package com.example.demo.configuration;

import com.example.demo.case_use.GetTask;
import com.example.demo.case_use.GetTaskImplement;
import com.example.demo.service.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetTask getTask(TaskService taskService){
        return new GetTaskImplement(taskService);
    }
}
