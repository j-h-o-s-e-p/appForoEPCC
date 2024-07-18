package com.app.services.implementations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.domain.entities.Person;
import com.app.domain.entities.User;
import com.app.repositories.PersonRepositoryImp;
import com.app.repositories.UserRepositoryImp;
import com.app.services.interfaces.IUserService;


@Service
public class UserServiceImp implements IUserService{

  @Autowired
  private PersonRepositoryImp personRepository;
  @Autowired
  private UserRepositoryImp userRepository;

  @Override
  @Transactional
  public User registerUser(Person person){
    try {
    Person personCreated = personRepository.save(person);
    User userCreated = new User();
    userCreated.setPerson(personCreated);
    return userRepository.save(userCreated);
    } catch(Exception e){
      throw new RuntimeException("Error al crear usuario",e);
    }
  };

  @Override
  @Transactional(readOnly = true)
  public User getUserbyId(Long id){
    return userRepository.findById(id)
      .orElseThrow();
  }
}
