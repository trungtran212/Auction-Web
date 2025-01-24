package com.example.InternProject.service.implement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.InternProject.entity.TaskEntity;
import com.example.InternProject.model.Tasks;
import com.example.InternProject.repository.TaskRepository;
import com.example.InternProject.repository.UserRepository;
import com.example.InternProject.service.interfaces.TaskService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Tasks createTask(Tasks task) throws Exception {
        try {
            TaskEntity taskEntity = new TaskEntity();
            task.setCreateAt(LocalDateTime.now());
            task.setUpdateAt(LocalDateTime.now());

            BeanUtils.copyProperties(task, taskEntity);
            taskRepository.save(taskEntity);

            return task;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<TaskEntity> getAllTasks() throws Exception {
        try {
            List<TaskEntity> taskEntities = taskRepository.findAll();
            List<TaskEntity> output = new ArrayList<>();

            taskEntities.forEach(taskEntity -> output.add(taskEntity));
            return output;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
