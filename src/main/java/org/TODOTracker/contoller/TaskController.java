package org.TODOTracker.contoller;


import org.TODOTracker.mapper.TaskResponse;
import org.TODOTracker.model.Task;
import org.TODOTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskResponse createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{userId}")
    public List<TaskResponse> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PutMapping("/{taskId}")
    public TaskResponse updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}