package org.TODOTracker.service;

import org.TODOTracker.mapper.TaskMapper;
import org.TODOTracker.repository.TaskRepository;
import org.TODOTracker.repository.UserRepository;
import org.TODOTracker.model.Task;
import org.TODOTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public TaskMapper createTask(TaskMapper taskMapper) {
        User user = userRepository.findById(taskMapper.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setCreatedDate(taskMapper.getCreatedDate());
        task.setDeadline(taskMapper.getDeadline());
        task.setUser(user);
        task.setDescription(taskMapper.getDescription());
        task.setTitle(taskMapper.getTitle());

        taskRepository.save(task);

        taskMapper.setId(task.getId());
        return taskMapper;

    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}