package uz.task.appjwtrealemailauditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.task.appjwtrealemailauditing.service.EmailService;
import uz.task.appjwtrealemailauditing.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register/director")
    public ResponseEntity<?> registerDirector(@RequestBody SignupRequest signupRequest) {
        userService.registerDirector(signupRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Director registered successfully"));
    }

    @PostMapping("/register/manager")
    public ResponseEntity<?> registerManager(@RequestBody SignupRequest signupRequest) {
        userService.registerManager(signupRequest);
        emailService.sendEmail(signupRequest.getEmail());
        return ResponseEntity.ok(new ApiResponse(true, "Manager registered successfully"));
    }

    @PostMapping("/register/employee")
    public ResponseEntity<?> registerEmployee(@RequestBody SignupRequest signupRequest) {
        userService.registerEmployee(signupRequest);
        emailService.sendEmployeeInviteEmail(signupRequest.getEmail());
        return ResponseEntity.ok(new ApiResponse(true, "Employee registered successfully"));
    }
}
