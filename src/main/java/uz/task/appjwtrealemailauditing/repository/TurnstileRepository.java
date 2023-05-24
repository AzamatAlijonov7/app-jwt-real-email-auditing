package uz.task.appjwtrealemailauditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.task.appjwtrealemailauditing.entity.Turnstile;
import uz.task.appjwtrealemailauditing.service.TurnstileService;

public interface TurnstileRepository extends JpaRepository<Turnstile,Long> {
}
