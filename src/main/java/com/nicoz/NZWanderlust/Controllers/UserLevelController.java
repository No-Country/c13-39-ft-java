package com.nicoz.NZWanderlust.Controllers;

import com.nicoz.NZWanderlust.Entities.UserLevel;
import com.nicoz.NZWanderlust.Services.UserLevelService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserLevelController {

    private final UserLevelService userLevelService;

    public UserLevelController(UserLevelService userLevelService) {
        this.userLevelService = userLevelService;
    }

    @GetMapping("/userLevel/{id}")
    public ResponseEntity<UserLevel> getUserLevelById(@PathVariable Long id) {
        try {
            UserLevel userLevel = userLevelService.searchUserLevel(id);
            return new ResponseEntity<>(userLevel, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    //*
    @PostMapping("/userLevel/")
    public void newUserLevel(@RequestBody UserLevel userLevel) {
    	UserLevel newUserLevel = userLevelService.newUserLevel(userLevel);
    }
	
    //*
    @DeleteMapping("/userLevel/{id}")
    public void deleteUserLevel(@PathVariable Long id) {
    	userLevelService.deleteUserLevel(id);
    }
    //*
    @PutMapping("/userLevel/{id}")
    public ResponseEntity<?> updateUserLevel(@PathVariable Long id, @RequestBody UserLevel userLevel) {
    	return userLevelService.updateUserLevel(id, userLevel);
    }
	   
    
}
