package com.pwc.blog.rest.api.service;
import com.pwc.blog.rest.api.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post createPost(Post post);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}
