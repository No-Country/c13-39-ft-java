package com.nicoz.NZWanderlust.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicoz.NZWanderlust.NewTicketTravelBuyerRequest;
import com.nicoz.NZWanderlust.Entities.Post;
import com.nicoz.NZWanderlust.Entities.User;
import com.nicoz.NZWanderlust.Repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Autowired
	private TicketTravelBuyerService ticketTravelBuyerService;

	@Transactional
	public Post newPost(Post post) {

		Post newPost = new Post();
		
		newPost.setTitle(post.getTitle());
		newPost.setDescription(post.getDescription());	
		newPost.setStartDate(post.getStartDate());
		newPost.setEndDate(post.getEndDate());
		newPost.setImages(post.getImages());
		newPost.setPrice(post.getPrice());
		newPost.setNumberOfTickets(post.getNumberOfTickets());
		newPost.setTransport(post.getTransport());
		newPost.setHotel(post.getHotel());
		newPost.setFood(post.getFood());
		newPost.setTouristicPlan(post.getTouristicPlan());
		newPost.setType(post.getType());	
		newPost.setMonth(post.getMonth());
		
		Post savedPost = postRepository.save(newPost);
		
		NewTicketTravelBuyerRequest ticketTravelBuyerRequest = new NewTicketTravelBuyerRequest(
				savedPost, null, savedPost.getPrice(), savedPost.getStartDate(),
				savedPost.getEndDate());
		
		
		for (int i = 0; i < post.getNumberOfTickets(); i++) {
			ticketTravelBuyerService.addTicketTravelBuyer(ticketTravelBuyerRequest);
		}
		
		
		return savedPost;

	}

	
    @Transactional
    public void deletePost(Integer id) {
    	Post post = searchPost(id);
    	postRepository.delete(post);
    }   
	
	@Transactional(readOnly = true)
	public Post searchPost(Integer id) {
		return postRepository.findById(id).get();
	}
	
	
    public List<Post> getPosts(){
        return postRepository.findAll();
    }
    
    public List<Post> getPostsByMonth(String mes){
        return postRepository.getPostsByMonth(mes);
    }

	@Transactional
	public Post updatePost(Integer id, Post post)  {
		Post postToUpdate = searchPost(id);
		postToUpdate.setTitle(post.getTitle());
		postToUpdate.setDescription(post.getDescription());	
		postToUpdate.setStartDate(post.getStartDate());
		postToUpdate.setEndDate(post.getEndDate());
		postToUpdate.setImages(post.getImages());
		postToUpdate.setPrice(post.getPrice());
		postToUpdate.setNumberOfTickets(post.getNumberOfTickets());
		postToUpdate.setTransport(post.getTransport());
		postToUpdate.setHotel(post.getHotel());
		postToUpdate.setFood(post.getFood());
		postToUpdate.setTouristicPlan(post.getTouristicPlan());
		postToUpdate.setType(post.getType());	
		postToUpdate.setMonth(post.getMonth());

		return postRepository.save(postToUpdate);

	}

}
