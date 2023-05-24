package uz.task.appjwtrealemailauditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.task.appjwtrealemailauditing.entity.TurnstileEntry;
import uz.task.appjwtrealemailauditing.service.TurnstileService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TurnstileController {

    @Autowired
    private TurnstileService turnstileService;

    @PostMapping("/turnstile/entry")
    public ResponseEntity<?> recordEntry(@RequestBody TurnstileRequest turnstileRequest) {
        turnstileService.recordEntry(turnstileRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Entry recorded successfully"));
    }

    @PostMapping("/turnstile/exit")
    public ResponseEntity<?> recordExit(@RequestBody TurnstileRequest turnstileRequest) {
        turnstileService.recordExit(turnstileRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Exit recorded successfully"));
    }

    @GetMapping("/turnstile/entries")
    public ResponseEntity<?> getAllEntries() {
        List<TurnstileEntry> entries = turnstileService.getAllEntries();
        return ResponseEntity.ok(entries);
    }

    @GetMapping("/turnstile/exits")
    public ResponseEntity<?> getAllExits() {
        List<TurnstileExit> exits = turnstileService.getAllExits();
        return ResponseEntity.ok(exits);
    }
}
