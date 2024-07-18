package com.proyect_v1.mvp.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyect_v1.mvp.domain.entities.Answer;
import com.proyect_v1.mvp.domain.entities.Entry;
import com.proyect_v1.mvp.domain.entities.Post;
import com.proyect_v1.mvp.domain.entities.User;
import com.proyect_v1.mvp.repositories.AnswerRepositoryImp;
import com.proyect_v1.mvp.services.interfaces.IAnswerService;

@Service
public class AnswerService implements IAnswerService{
  @Autowired
  private UserServiceImp userService;

  @Autowired
  private PostService postService;

  @Autowired
  private EntryService entryService;

  @Autowired
  private AnswerRepositoryImp answerRepository;

  @Override
  @Transactional
  public Answer createAnswer(Long post_id_to_reply,Long id_user,String content){
    try{
      User user = userService.getUserbyId(id_user);
      Entry entryCreated = entryService.createEntry(user, content);
      Post postToReply = postService.getPostById(post_id_to_reply);
  
      Answer answerCreated = new Answer();
      answerCreated.setEntry(entryCreated);
      answerCreated.setPost(postToReply);
      //crear una entry con el user de
      return answerRepository.save(answerCreated);
    }catch(Exception e){
      throw new RuntimeException("No se pudo crear la respuesta");
    }
  };

  @Override
  @Transactional(readOnly = true)
  public Answer getAnswerById(Long id_answer){
    return answerRepository.findById(id_answer)
      .orElseThrow();
  };

}