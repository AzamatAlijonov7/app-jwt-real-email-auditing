package uz.task.appjwtrealemailauditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.task.appjwtrealemailauditing.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
