package com.pwc.blog.rest.api.contoller;

import com.pwc.blog.rest.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pwc.blog.rest.api.entity.Post;
import java.util.List;
@RequestMapping("/api/posts")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost(){
        List<Post> data = postService.getAllPosts();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post data = postService.createPost(post);
        return new ResponseEntity<>(data,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id){
        Post data = postService.getPostById(id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long postId,
                                           @RequestBody Post post){
        Post data = postService.updatePost(postId, post);
        return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
