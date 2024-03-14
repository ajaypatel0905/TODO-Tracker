package org.TODOTracker.contoller;

import org.TODOTracker.model.AddTask;
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
    public Task createTask(@RequestBody AddTask addTask) {
        return taskService.createTask(addTask);
    }

    @GetMapping("/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody AddTask addTask) {
        return taskService.updateTask(taskId, addTask);
    }

    @PutMapping("completed/{taskId}")
    public Task completeTask(@PathVariable Long taskId) {
        return taskService.completeTask(taskId);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}