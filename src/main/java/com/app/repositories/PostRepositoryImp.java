package com.proyect_v1.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect_v1.mvp.domain.entities.Post;

public interface PostRepositoryImp extends JpaRepository<Post,Long>{

}