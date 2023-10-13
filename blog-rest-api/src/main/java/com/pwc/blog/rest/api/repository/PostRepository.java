package com.pwc.blog.rest.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pwc.blog.rest.api.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
}
