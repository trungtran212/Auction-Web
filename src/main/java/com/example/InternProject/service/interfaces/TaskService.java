package com.example.InternProject.service.interfaces;

import java.util.List;

import com.example.InternProject.entity.TaskEntity;
import com.example.InternProject.model.Tasks;

public interface TaskService {
    Tasks createTask(Tasks task) throws Exception;

    List<TaskEntity> getAllTasks() throws Exception;
}
