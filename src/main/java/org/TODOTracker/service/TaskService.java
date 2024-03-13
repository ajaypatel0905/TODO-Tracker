package org.TODOTracker.service;


import org.TODOTracker.convertor.TaskConvertor;
import org.TODOTracker.mapper.TaskResponse;
import org.TODOTracker.repository.TaskRepository;
import org.TODOTracker.repository.UserRepository;
import org.TODOTracker.model.Task;
import org.TODOTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    private final TaskConvertor convertor = new TaskConvertor();

    public TaskResponse createTask(Task task) {
        User user = userRepository.findById(task.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return convertor.convert(taskRepository.save(task));

    }

    public List<TaskResponse> getTasksByUserId(Long userId) {
        List<Task> tasks = taskRepository.findByUserId(userId);

        return convertor.convertAll(tasks);
    }

    public TaskResponse updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        return convertor.convert(taskRepository.save(task));
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}