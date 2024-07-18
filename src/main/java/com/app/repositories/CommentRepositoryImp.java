package com.app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entities.Comment;


public interface CommentRepositoryImp extends JpaRepository<Comment,Long>{
    

}