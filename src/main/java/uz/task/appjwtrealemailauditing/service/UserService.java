package uz.task.appjwtrealemailauditing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.task.appjwtrealemailauditing.controller.SignupRequest;
import uz.task.appjwtrealemailauditing.entity.User;
import uz.task.appjwtrealemailauditing.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow();

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();

        userRepository.delete(user);
    }

    public void registerDirector(SignupRequest signupRequest) {

    }

    public void registerManager(SignupRequest signupRequest) {

    }

    public void registerEmployee(SignupRequest signupRequest) {

    }
}