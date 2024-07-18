package com.app.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.entities.Answer;
import com.app.domain.entities.Comment;
import com.app.domain.entities.Entry;
import com.app.domain.entities.Post;
import com.app.domain.entities.User;
import com.app.repositories.CommentRepository;
import com.app.repositories.CommentRepositoryImp;
import com.app.services.interfaces.ICommentService;



public class CommentService implements ICommentService{
    
  @Autowired
  private UserServiceImp userService;

  @Autowired
  private PostService postService;
  
  @Autowired
  private AnswerService answerService;

  @Autowired
  private CommentRepositoryImp commentRepository;


  @Override
  public Comment postComment(Long postId, Long userId, String content) {
      try {
          Post post = postService.getPostById(postId);
          Entry entry = post.getEntry();
          User user = userService.getUserById(userId);

          Comment comment = new Comment();
          comment.setUser(user);
          comment.setEntry(entry);
          comment.setContent(content);

          return commentRepository.save(comment);
      } catch (Exception e) {
          throw new RuntimeException("No se pudo crear el comentario al post", e);
      }
  }

  @Override
  public Comment answerComment(Long answerId, Long userId, String content) {
      try {
          Answer answer = answerService.getAnswerById(answerId);
          Entry entry = answer.getEntry();
          User user = userService.getUserById(userId);

          Comment comment = new Comment();
          comment.setEntry(entry);
          comment.setUser(user);
          comment.setContent(content);

          return commentRepository.save(comment);
      } catch (Exception e) {
          throw new RuntimeException("No se pudo crear el comentario al answer", e);
      }
  }


}
