package com.nicoz.NZWanderlust.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.nicoz.NZWanderlust.Entities.Post;
import com.nicoz.NZWanderlust.Entities.TicketTravelBuyer;
import com.nicoz.NZWanderlust.Services.PostService;

@RestController
@RequestMapping("/")
public class PostController {

	
    @Autowired
    private PostService postService;
    
    @PostMapping("/post")
    public ResponseEntity<?> addPost(@RequestBody Post post) {
    	Post newPost = postService.newPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }
	
    
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
    	postService.deletePost(id);      	
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
	
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        try {
        	Post post = postService.searchPost(id);      	
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/post")
    public List<Post> getPosts(){
        return postService.getPosts();
    }
    
    @GetMapping("/posts")
    public ResponseEntity<?> getPostsLists(){
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> message = new HashMap<>();
		
    	List<Post> completeList = postService.getPosts();
		List<Post> vuelos = new ArrayList();
		List<Post> paquetes = new ArrayList();
		List<Post> alojamientos = new ArrayList();
		List<Post> turismo = new ArrayList();
		List<Post> transporte = new ArrayList();
	
		for (Post aux : completeList) {
			if (aux.getType().equalsIgnoreCase("Vuelo")) {
				vuelos.add(aux);
				
			} else if (aux.getType().equalsIgnoreCase("Paquete")) {
				paquetes.add(aux);
				
			} else if (aux.getType().equalsIgnoreCase("Alojamiento")) {
				alojamientos.add(aux);
				
			} else if (aux.getType().equalsIgnoreCase("Turismo")) {
				turismo.add(aux);
				
			} else {
				transporte.add(aux);
				
			}
		}
         
		message.put("vuelos", vuelos);
		message.put("paquetes", paquetes);
		message.put("alojamientos", alojamientos);
		message.put("turismo", turismo);
		message.put("transporte", transporte);
		response.put("posts", message);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        
        
    }   

    @GetMapping("/posts/{mes}")
    public ResponseEntity<?> getPostsByMonth(@PathVariable("mes") String mes){
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> message = new HashMap<>();
		
    	List<Post> completeList = postService.getPostsByMonth(mes);
		List<Post> vuelos = new ArrayList();
		List<Post> paquetes = new ArrayList();
		List<Post> alojamientos = new ArrayList();
		List<Post> turismo = new ArrayList();
		List<Post> transporte = new ArrayList();
	
		for (Post aux : completeList) {
			if (aux.getType().equalsIgnoreCase("Vuelo")) {
				vuelos.add(aux);
				
			} else if (aux.getType().equalsIgnoreCase("Paquete")) {
				paquetes.add(aux);
				
			} else if (aux.getType().equalsIgnoreCase("Alojamiento")) {
				alojamientos.add(aux);
				
			} else if (aux.getType().equalsIgnoreCase("Turismo")) {
				turismo.add(aux);
				
			} else {
				transporte.add(aux);
				
			}
		}
         
		message.put("vuelos", vuelos);
		message.put("paquetes", paquetes);
		message.put("alojamientos", alojamientos);
		message.put("turismo", turismo);
		message.put("transporte", transporte);
		response.put("posts", message);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        
        
    } 
    
    @GetMapping("/post-ticket/{id}")
    public ResponseEntity<?> getPostTicket(@PathVariable Integer id){
		Post post = postService.searchPost(id);      
		List<TicketTravelBuyer> ticketList = post.getTicketTravelBuyer();
		
		Long availableTicket = null;

		for (TicketTravelBuyer aux : ticketList) {
			if (aux.getUser() == null) {
				availableTicket = aux.getTicketTravelBuyerId();
				break;
			}
		}
		System.out.println(availableTicket);
		Map<String, Object> response = new HashMap<>();	
		response.put("availableTicket", availableTicket);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);    
        
    } 
    
    
      	
    @PutMapping("/post/{id}")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable Integer id) {
    	Post updatedPost = postService.updatePost(id, post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }	
	
	
}
