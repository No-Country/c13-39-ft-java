package com.nicoz.NZWanderlust.Controllers;

import com.nicoz.NZWanderlust.NewUserRequest;
import com.nicoz.NZWanderlust.Entities.User;
import com.nicoz.NZWanderlust.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/users/")
    public ResponseEntity<User> updateUser(@RequestBody NewUserRequest userRequest) {
        User user = userService.addUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userRequest ){
        return userService.updateUser(id, userRequest);
        }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return userService.delete(id);

    }

}
