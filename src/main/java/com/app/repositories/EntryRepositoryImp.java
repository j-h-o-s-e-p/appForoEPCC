package com.proyect_v1.mvp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect_v1.mvp.domain.entities.Entry;

public interface EntryRepositoryImp extends JpaRepository<Entry,Long>{

}
