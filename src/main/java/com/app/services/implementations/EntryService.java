package com.proyect_v1.mvp.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyect_v1.mvp.domain.entities.Entry;
import com.proyect_v1.mvp.domain.entities.User;
import com.proyect_v1.mvp.repositories.EntryRepositoryImp;
import com.proyect_v1.mvp.services.interfaces.IEntryService;

@Service
public class EntryService implements IEntryService{

  // @Autowired
  // private UserServiceImp userService;
  @Autowired
  private EntryRepositoryImp entryRepository;

  @Override
  @Transactional
  public Entry createEntry(User user,String content){
    try{
      Entry entryCreated = new Entry();
      entryCreated.setUser(user);
      entryCreated.setContent(content);

      return entryRepository.save(entryCreated);
    }catch(Exception e){
      throw new RuntimeException("No se pudo crear el entry");
    }
  };

  @Override
  @Transactional
  public void addCommentToEntry(Long id_entry){
    if(!entryRepository.existsById(id_entry)){
      throw new RuntimeException("Nos e puede añadir el contador de comentarios");
    }
    Optional<Entry> entryO = entryRepository.findById(id_entry);
    Entry entry = entryO.get();
    entry.setComments(entry.getComments()+1);
    entryRepository.save(entry);
  };

}
