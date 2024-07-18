package com.app.services.interfaces;

import com.app.domain.entities.Person;
import com.app.domain.entities.User;

public interface IUserService {

  public User registerUser(Person person);

  public User getUserbyId(Long id);

}
