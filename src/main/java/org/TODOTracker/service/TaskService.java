package org.TODOTracker.service;

import org.TODOTracker.TaskRequest;
import org.TODOTracker.repository.TaskRepository;
import org.TODOTracker.repository.UserRepository;
import org.TODOTracker.model.Task;
import org.TODOTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllUserTasks(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public void updateTaskStatus(Long taskId){
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTaskStatus(task.getTaskStatus() ? false : true);
    }


//    public Task updateTask(Long taskId, TaskRequest taskrequest) {
//        Task task = taskRepository.findById(taskId)
//                .orElseThrow(() -> new RuntimeException("Task not found"));
//        task.setTitle(taskrequest.getTitle());
//        task.setCreatedDate(taskrequest.getCreatedDate());
//        task.setDeadline(taskrequest.getDeadline());
//        task.setDescription(taskrequest.getDescription());
//        return taskRepository.save(task);
//    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}