package com.proyect_v1.mvp.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @OneToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "id_entry",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_entry_post"),nullable = false)
  private Entry entry;

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "INT DEFAULT 0")
  private int views;

  @Column(columnDefinition = "INT DEFAULT 0")
  private int answers;

  public void setEntry(Entry entry) {
    this.entry = entry;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setViews(int views) {
    this.views = views;
  }

  public void setAnswers(int answers) {
    this.answers = answers;
  }

  public Long getId() {
    return Id;
  }

  public Entry getEntry() {
    return entry;
  }

  public String getTitle() {
    return title;
  }

  public int getViews() {
    return views;
  }

  public int getAnswers() {
    return answers;
  }
}