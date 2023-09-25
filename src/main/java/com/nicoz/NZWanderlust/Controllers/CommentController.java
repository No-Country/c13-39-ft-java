package com.nicoz.NZWanderlust.Controllers;

import com.nicoz.NZWanderlust.Entities.Comment;
import com.nicoz.NZWanderlust.NewCommentRequest;
import com.nicoz.NZWanderlust.Services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<Comment> getComments(){return commentService.getComments();}

    @PostMapping("/comments")
    public void addComment(@RequestBody NewCommentRequest request){
        commentService.addComment(request);
    }

    @PutMapping("/comment/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable("commentId") Long id,
                                                 @RequestBody Comment commentDetails){
        return commentService.updateComment(id, commentDetails);
    }

    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long id){
        commentService.deleteComment(id);
    }
}
