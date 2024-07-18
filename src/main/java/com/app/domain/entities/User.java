package com.app.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id; 
   @OneToOne
   @JoinColumn(name = "id_person", referencedColumnName = "id", 
   foreignKey = @ForeignKey(name = "FK_person_user"), nullable = false)

   private Person person;
   public void  setPerson(Person person){
    this.person = person;
   }
   public Long getId(){
    return id;
   }
   public Person getPerson(){
    return person;
   }
}
