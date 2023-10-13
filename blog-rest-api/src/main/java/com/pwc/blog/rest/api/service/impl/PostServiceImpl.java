package com.pwc.blog.rest.api.service.impl;

import com.pwc.blog.rest.api.entity.Post;
import com.pwc.blog.rest.api.repository.PostRepository;
import com.pwc.blog.rest.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("resource not found"));
        return post;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post postUpdate) {
        // get the post by id from database
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("resource not found"));
        // get update data
        post.setTitle(postUpdate.getTitle());
        post.setDescription(postUpdate.getDescription());
        post.setContent(postUpdate.getContent());
        // save the changes
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        // get the post by id from database
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("resource not found"));
        postRepository.deleteById(id);
    }
}
