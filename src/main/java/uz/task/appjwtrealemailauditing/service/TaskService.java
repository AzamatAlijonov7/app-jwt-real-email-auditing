package uz.task.appjwtrealemailauditing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import uz.task.appjwtrealemailauditing.controller.TaskRequest;
import uz.task.appjwtrealemailauditing.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void createTask(TaskRequest taskRequest) {

    }

    public void updateTask(Long id, Object status) {

    }

    public void markTaskAsCompleted(Long id) {

    }

    public void createTask(TaskRequest taskRequest) {

    }
}
