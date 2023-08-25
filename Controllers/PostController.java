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
import com.nicoz.NZWanderlust.Entity.Post;
import com.nicoz.NZWanderlust.Service.BuyerService;
import com.nicoz.NZWanderlust.Service.PostService;

@RestController
@RequestMapping("/")
public class PostController {

	
    @Autowired
    private PostService postService;
    
    @PostMapping("/post/nuevoPost")
    public ResponseEntity<?> nuevoPost(@RequestBody Post post) {
    	Post newPost = postService.newPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }
	
    
    @DeleteMapping("/post/bajaPost/{id}")
    public ResponseEntity<?> bajaPost(@PathVariable Integer id) {
    	postService.deletePost(id);      	
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
	
    @GetMapping("/post/verPost/{id}")
    public ResponseEntity<Post> verPost(@PathVariable Integer id) {
        try {
        	Post post = postService.searchPost(id);      	
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (Exception e) {
        	return ResponseEntity.notFound().build();
        }
    }
    

   	
    @PutMapping("/post/modificarPost")
    public ResponseEntity<?> modificarPost(@RequestBody Post post) {
    	Post updatedPost = postService.updatePost(post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }	
	
	
}
