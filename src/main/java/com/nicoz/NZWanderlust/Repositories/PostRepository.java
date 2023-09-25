package com.nicoz.NZWanderlust.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nicoz.NZWanderlust.Entities.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query("SELECT a FROM Post a WHERE a.month = :month")
	public List<Post> getPostsByMonth(@Param("month") String month);
	
	
}