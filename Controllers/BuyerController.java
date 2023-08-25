package com.nicoz.NZWanderlust.Controller;

import java.util.HashMap;
import java.util.Map;

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
import com.nicoz.NZWanderlust.Service.BuyerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class BuyerController {
	
    @Autowired
    private BuyerService buyerService;
    
    @PostMapping("/buyer/nuevoComprador")
    public ResponseEntity<?> nuevoComprador(@RequestBody Buyer buyer) {
        	Buyer newBuyer = buyerService.newBuyer(buyer);
            return new ResponseEntity<>(newBuyer, HttpStatus.OK);
    }
	
    
    @DeleteMapping("/buyer/bajaComprador/{id}")
    public ResponseEntity<?> deleteBuyer(@PathVariable Integer id) {
    	buyerService.deleteBuyer(id);      	
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
	
    @GetMapping("/buyer/verComprador/{id}")
    public ResponseEntity<Buyer> verComprador(@PathVariable Integer id) {
        try {
        	Buyer buyer = buyerService.searchBuyer(id);      	
            return new ResponseEntity<>(buyer, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }
    

   	
    @PutMapping("/buyer/modificarComprador")
    public ResponseEntity<?> modificarComprador(@RequestBody Buyer buyer) {
       	Buyer updatedBuyer = buyerService.updateBuyer(buyer);
        return new ResponseEntity<>(updatedBuyer, HttpStatus.OK);
    }
	   
	
	
	
}
