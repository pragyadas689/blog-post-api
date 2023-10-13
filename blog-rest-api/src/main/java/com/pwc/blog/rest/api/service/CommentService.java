package com.pwc.blog.rest.api.service;
import com.pwc.blog.rest.api.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long postId,Comment comment);
    List<Comment> getCommentsByPostId(Long postId);
    Comment getCommentById(Long postId,Long commentId);
    Comment updateComment(Long postId, Long commentId, Comment updateComment);
    void deleteComment(Long postId,Long commentId);

}
