package com.pwc.blog.rest.api.service.impl;

import com.pwc.blog.rest.api.entity.Comment;
import com.pwc.blog.rest.api.repository.CommentRepository;
import com.pwc.blog.rest.api.repository.PostRepository;
import com.pwc.blog.rest.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pwc.blog.rest.api.entity.Post;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Long postId, Comment comment) {
        Post post = postRepository
                .findById(postId)
                .orElseThrow(()-> new RuntimeException("resource not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;
    }

    @Override
    public Comment getCommentById(Long postId, Long commentId) {
        Post post = postRepository
                .findById(postId)
                .orElseThrow(()-> new RuntimeException("resource not found"));
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(()-> new RuntimeException("resource not found"));
        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException("comment doesnot belong to post");
        }
        return comment;
    }

    @Override
    public Comment updateComment(Long postId, Long commentId, Comment updateComment) {
        Post post = postRepository
                .findById(postId)
                .orElseThrow(()-> new RuntimeException("resource not found"));
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(()-> new RuntimeException("resource not found"));
        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException("comment doesnot belong to post");
        }
        comment.setName(updateComment.getName());
        comment.setEmail(updateComment.getEmail());
        comment.setBody(updateComment.getBody());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Post post = postRepository
                .findById(postId)
                .orElseThrow(()-> new RuntimeException("resource not found"));
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(()-> new RuntimeException("resource not found"));
        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException("comment doesnot belong to post");
        }
        commentRepository.deleteById(commentId);

    }
}
