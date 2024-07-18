package com.proyect_v1.mvp.services.interfaces;

import com.proyect_v1.mvp.domain.entities.Entry;
import com.proyect_v1.mvp.domain.entities.User;

public interface IEntryService {

  public Entry createEntry(User user,String content);

  public void addCommentToEntry(Long id_entry);
  
}
