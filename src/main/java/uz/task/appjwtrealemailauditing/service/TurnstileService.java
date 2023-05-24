package uz.task.appjwtrealemailauditing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import uz.task.appjwtrealemailauditing.controller.TurnstileExit;
import uz.task.appjwtrealemailauditing.controller.TurnstileRequest;
import uz.task.appjwtrealemailauditing.entity.Turnstile;
import uz.task.appjwtrealemailauditing.entity.TurnstileEntry;
import uz.task.appjwtrealemailauditing.entity.User;
import uz.task.appjwtrealemailauditing.repository.TurnstileRepository;

import java.util.List;

@Service
public class TurnstileService {

    @Autowired
    private TurnstileRepository turnstileRepository;

    public List<Turnstile> getAllTurnstiles() {
        return turnstileRepository.findAll();
    }

    public Turnstile getTurnstileById(Long id) {
        return turnstileRepository.findById(id).orElse(null);
    }

    public Turnstile addTurnstile(Turnstile turnstile) {
        return turnstileRepository.save(turnstile);
    }

    public Turnstile updateTurnstile(Turnstile turnstile) {
        return turnstileRepository.save(turnstile);
    }

    public void deleteTurnstile(Long id) {
        turnstileRepository.deleteById(id);
    }

    public void enter(Long turnstileId, Long userId) {
        Turnstile turnstile = turnstileRepository.findById(turnstileId).orElse(null);
        if (turnstile != null) {
            SimpleJpaRepository userRepository = null;
            User user = (User) userRepository.findById(userId).orElse(null);
            if (user != null) {
                if (turnstile.getIsLocked()) {
                    System.out.println("The turnstile is locked. Please try again later.");
                } else {
                    turnstile.setIsLocked(true);
                    turnstile.setLastUser(user);
                    turnstileRepository.save(turnstile);
                    System.out.println("Welcome, " + user.getName() + "!");
                }
            } else {
                System.out.println("User not found.");
            }
        } else {
            System.out.println("Turnstile not found.");
        }
    }

    public void exit(Long turnstileId) {
        Turnstile turnstile = turnstileRepository.findById(turnstileId).orElse(null);
        if (turnstile != null) {
            if (turnstile.getIsLocked()) {
                turnstile.setIsLocked(false);
                turnstileRepository.save(turnstile);
                System.out.println("Goodbye!");
            } else {
                System.out.println("The turnstile is already unlocked.");
            }
        } else {
            System.out.println("Turnstile not found.");
        }
    }

    public void recordEntry(TurnstileRequest turnstileRequest) {

    }

    public void recordExit(TurnstileRequest turnstileRequest) {

    }

    public List<TurnstileEntry> getAllEntries() {
        return null;
    }

    public List<TurnstileExit> getAllExits() {
        return null;
    }
}
