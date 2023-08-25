package com.nicoz.NZWanderlust.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nicoz.NZWanderlust.Entity.Buyer;
import com.nicoz.NZWanderlust.Entity.UserLevel;
import com.nicoz.NZWanderlust.Service.UserLevelService;
import com.nicoz.NZWanderlust.Service.BuyerService;

@RestController
@RequestMapping("/")
public class UserLevelController {

	
    @Autowired
    private UserLevelService userLevelService;
    
    @PostMapping("/userLevel/nuevoUserLevel/{idUser}")
    public ResponseEntity<?> nuevoUserLevel(@PathVariable Integer idUser) {
    	UserLevel newUserLevel = userLevelService.newUserLevel(idUser);
        return new ResponseEntity<>(newUserLevel, HttpStatus.OK);
    }
	
    
    @DeleteMapping("/userLevel/bajaUserLevel/{id}")
    public ResponseEntity<?> bajaUserLevel(@PathVariable Integer id) {
    	userLevelService.deleteUserLevel(id);      	
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
	
    @GetMapping("/userLevel/verUserLevel/{id}")
    public ResponseEntity<UserLevel> verUserLevel(@PathVariable Integer id) {
        try {
        	UserLevel userLevel = userLevelService.searchUserLevel(id);      	
            return new ResponseEntity<>(userLevel, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }
    

   	
    @PutMapping("/userLevel/modificarUserLevel")
    public ResponseEntity<?> modificarUserLevel(@RequestBody UserLevel userLevel) {
    	UserLevel updatedUserLevel = userLevelService.updateUserLevel(userLevel);
        return new ResponseEntity<>(updatedUserLevel, HttpStatus.OK);
    }
	   
    
}
