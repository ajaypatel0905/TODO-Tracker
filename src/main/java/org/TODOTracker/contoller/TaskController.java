package org.TODOTracker.contoller;

import org.TODOTracker.TaskRequest;
import org.TODOTracker.model.Task;
import org.TODOTracker.model.User;
import org.TODOTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.TODOTracker.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskRequest taskrequest) {

        Task task = new Task();
        task.setTitle(taskrequest.getTitle());
        task.setCreatedDate(taskrequest.getCreatedDate());
        task.setTaskStatus(false);
        task.setDeadline(taskrequest.getDeadline());
        task.setDescription(taskrequest.getDescription());
        User user = userRepository.findById(taskrequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);
        taskService.createTask(task);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    @GetMapping("/byUser/{userId}")
    public List<Task> getAllUserTasks(@PathVariable Long userId) {
        return taskService.getAllUserTasks(userId);
    }

    @PutMapping("/byUser/{taskId}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable Long taskId){
        taskService.updateTaskStatus(taskId);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

//    @PutMapping("/byUser/{taskId}")
//    public ResponseEntity<String> updateTask(@PathVariable Long taskId, TaskRequest taskRequest){
//        taskService.updateTask(taskId,taskRequest);
//        return new ResponseEntity<>("success", HttpStatus.CREATED);
//    }


    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}