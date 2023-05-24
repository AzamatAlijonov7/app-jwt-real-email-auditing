package uz.task.appjwtrealemailauditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import uz.task.appjwtrealemailauditing.entity.Employee;
import uz.task.appjwtrealemailauditing.service.Attendance;
import uz.task.appjwtrealemailauditing.service.EmployeeService;
import uz.task.appjwtrealemailauditing.service.SalaryRequest;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees/{id}/attendance")
    public ResponseEntity<?> getEmployeeAttendance(@PathVariable Long id, @RequestParam String startDate, @RequestParam String endDate) {
        List<Attendance> attendance = employeeService.getEmployeeAttendance(id, startDate, endDate);
        return ResponseEntity.ok(attendance);
    }

    @GetMapping("/employees/{id}/tasks")
    public ResponseEntity<?> getEmployeeTasks(@PathVariable Long id, @RequestParam String startDate, @RequestParam String endDate) {
        List<Task> tasks = employeeService.getEmployeeTasks(id, startDate, endDate);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/employees/{id}/salary")
    ResponseEntity<?> recordSalary(@PathVariable Long id, @RequestBody SalaryRequest salaryRequest) {
        employeeService.recordSalary(id, salaryRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Salary recorded successfully"));
    }

    @GetMapping("/employees/salaries")
    public ResponseEntity<?> getAllSalaries() {
        List<Salary> salaries = employeeService.getAllSalaries();
        return ResponseEntity.ok(salaries);
    }

    @GetMapping("/employees/salaries/{month}")
    public ResponseEntity<?> getSalariesByMonth(@PathVariable String month) {
        List<Salary> salaries = employeeService.getSalariesByMonth(month);
        return ResponseEntity.ok(salaries);
    }

    @GetMapping("/employees/tasks")
    public <TaskStatus> ResponseEntity<?> getTasksStatus() {
        List<TaskStatus> taskStatuses = (List<TaskStatus>) employeeService.getTasksStatus();
        return ResponseEntity.ok(taskStatuses);
    }
}
