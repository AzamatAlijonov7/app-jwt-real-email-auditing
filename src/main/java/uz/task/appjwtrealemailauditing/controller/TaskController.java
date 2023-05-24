package uz.task.appjwtrealemailauditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import uz.task.appjwtrealemailauditing.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        taskService.createTask(taskRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Task created successfully"));
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/tasks/{id}/status")
    public ResponseEntity<?> updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatusRequest taskStatusRequest) {
        taskService.updateTask(id, taskStatusRequest.getStatus());
        return ResponseEntity.ok(new ApiResponse(true, "Task status updated successfully"));
    }

    @PutMapping("/tasks/{id}/completed")
    public ResponseEntity<?> markTaskAsCompleted(@PathVariable Long id) {
        taskService.markTaskAsCompleted(id);
        return ResponseEntity.ok(new ApiResponse(true, "Task marked as completed successfully"));
    }
}
