package com.pwc.blog.rest.api.contoller;

import com.pwc.blog.rest.api.entity.Comment;
import com.pwc.blog.rest.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:9000/api/posts
// http://localhost:9000/api/posts/1/comments

@RequestMapping("/api/")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable("postId") Long postId,
                                                 @RequestBody Comment comment){
        Comment data = commentService.createComment(postId, comment);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable("postId") Long postId){
        List<Comment> data = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentsById(@PathVariable("postId") Long postId,
                                                   @PathVariable("commentId") Long commentId){
        Comment data = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentsById(@PathVariable("postId") Long postId,
                                                   @PathVariable("commentId") Long commentId,
                                                   @RequestBody Comment comment){
        Comment data = commentService.updateComment(postId, commentId, comment);
        return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("postId") Long postId,
                                                @PathVariable("commentId") Long commentId){
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("comment deleted successfully", HttpStatus.NO_CONTENT);
    }
}
