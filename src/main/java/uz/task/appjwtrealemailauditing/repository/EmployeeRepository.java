package uz.task.appjwtrealemailauditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.task.appjwtrealemailauditing.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
