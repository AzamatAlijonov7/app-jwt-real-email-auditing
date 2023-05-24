package uz.task.appjwtrealemailauditing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import uz.task.appjwtrealemailauditing.controller.Salary;
import uz.task.appjwtrealemailauditing.entity.Employee;
import uz.task.appjwtrealemailauditing.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return (Employee) employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Attendance> getEmployeeAttendance(Long id, String startDate, String endDate) {
        return null;
    }

    public List<Task> getEmployeeTasks(Long id, String startDate, String endDate) {
        return null;
    }

    public void recordSalary(Long id, SalaryRequest salaryRequest) {
    }

    public List<Salary> getAllSalaries() {
        return null;
    }

    public List<Salary> getSalariesByMonth(String month) {
        return null;
    }

    public List<TaskStatus> getTasksStatus() {
        return null;
    }

    public void recordSalary(Long id, uz.task.appjwtrealemailauditing.controller.SalaryRequest salaryRequest) {

    }
}