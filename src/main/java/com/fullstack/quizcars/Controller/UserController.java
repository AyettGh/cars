package com.fullstack.quizcars.Controller;

import com.fullstack.quizcars.DTO.UserRequest;
import com.fullstack.quizcars.Service.UserService;
import com.fullstack.quizcars.classes.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/q")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest) {
        User newUser = new User();
        newUser.setUsername(userRequest.getUsername());
        newUser.setPassword(userRequest.getPassword());
        newUser.setRole("ROLE_USER");

        User savedUser = userService.saveUser(newUser);
        HashMap<String, Object> response = new HashMap<>();
        response.put("username", savedUser.getUsername());
        response.put("role", savedUser.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getUserById(id);
        return optionalUser.map(user -> ResponseEntity.ok(user)).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
