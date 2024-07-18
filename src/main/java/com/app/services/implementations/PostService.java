package com.proyect_v1.mvp.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyect_v1.mvp.domain.entities.Entry;
import com.proyect_v1.mvp.domain.entities.Post;
import com.proyect_v1.mvp.domain.entities.User;
import com.proyect_v1.mvp.repositories.PostRepositoryImp;
import com.proyect_v1.mvp.services.interfaces.IPostService;



@Service
public class PostService implements IPostService{

  @Autowired
  private EntryService entryService;

  @Autowired
  private PostRepositoryImp postRepository;

  @Autowired
  private UserServiceImp userService;

  @Override
  @Transactional
  public Post createPost(Long id_user,String title,String content){
    try {
      User user = userService.getUserbyId(id_user);

      Entry entrySaved = entryService.createEntry(user, content);

      Post postCreated = new Post();
      postCreated.setEntry(entrySaved);
      postCreated.setTitle(title);

      return postRepository.save(postCreated);
      
    } catch(Exception e){
      throw new RuntimeException("No se pudo crear el post");
    }
  }

  @Transactional(readOnly = true)
  public Post getPostById(Long id_post){
    return postRepository.findById(id_post)
      .orElseThrow();
  }

}