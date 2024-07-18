package com.proyect_v1.mvp.services.interfaces;

import com.proyect_v1.mvp.domain.entities.Answer;

public interface IAnswerService {

  public Answer createAnswer(Long post_id_to_reply,Long id_user,String content);

  public Answer getAnswerById(Long id_answer);

}