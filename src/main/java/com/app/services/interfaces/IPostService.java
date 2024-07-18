package com.proyect_v1.mvp.services.interfaces;

import com.proyect_v1.mvp.domain.entities.Post;

public interface IPostService {
  public Post createPost (Long id_user,String title,String content);

  //public Post updatePost(Long id_post,Post modifiedPost);
  
}