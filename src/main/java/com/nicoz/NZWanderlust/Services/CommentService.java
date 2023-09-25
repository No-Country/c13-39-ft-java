package com.nicoz.NZWanderlust.Services;

import com.nicoz.NZWanderlust.Entities.Comment;
import com.nicoz.NZWanderlust.NewCommentRequest;
import com.nicoz.NZWanderlust.Repositories.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    public void addComment(NewCommentRequest commentRequest){
        Comment comment = new Comment();
        comment.setUserId(commentRequest.getUserId());
        comment.setTitle(commentRequest.getTitle());
        comment.setDetails(commentRequest.getDetails());
        comment.setScore(commentRequest.getScore());
        commentRepository.save(comment);
    }

    public ResponseEntity<Comment> updateComment(Long id, Comment commentDetails){
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (!optionalComment.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Comment comment = optionalComment.get();
        comment.setUserId(commentDetails.getUserId());
        comment.setTitle(commentDetails.getTitle());
        comment.setDetails(commentDetails.getDetails());
        comment.setScore(commentDetails.getScore());
        Comment updatedComment = commentRepository.save(comment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
