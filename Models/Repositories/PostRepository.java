package com.nicoz.NZWanderlust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicoz.NZWanderlust.Entity.Post;


public interface PostRepository extends JpaRepository<Post, Integer>{

}