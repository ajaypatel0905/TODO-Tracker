package org.TODOTracker.service;

import org.TODOTracker.model.AddTask;
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

    public Task createTask(AddTask addTask) {

        Task  task = new Task();
        task.setTitle(addTask.getTitle());
        task.setDescription(addTask.getDescription());
        task.setCreatedDate((addTask.getCreatedDate()));
        task.setDeadline(addTask.getDeadline());
        task.setCompleted(false);

        User user = userRepository.findById(addTask.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(!user.getExist()){
            throw new RuntimeException("User not found");
        }
        return taskRepository.findByUserId(userId);
    }

    public Task updateTask(Long taskId, AddTask taskDetails) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDeadline(taskDetails.getDeadline());
        return taskRepository.save(task);
    }

    public Task completeTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.deleteById(taskId);
    }
}