package com.example.InternProject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternProject.entity.TaskEntity;
import com.example.InternProject.model.Tasks;
import com.example.InternProject.service.interfaces.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) throws Exception {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/tasks/getAllTasks")
    public ResponseEntity<List<TaskEntity>> getAllTasks() throws Exception {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
}
