package com.example.demo.controller;

import com.example.demo.case_use.CreateTask;
import com.example.demo.case_use.DeleteTask;
import com.example.demo.case_use.GetTask;
import com.example.demo.case_use.UpdateTask;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {
    private CreateTask createUser;
    private GetTask getUser;
    private UpdateTask updateUser;
    private DeleteTask deleteUser;
}
