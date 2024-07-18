package com.app.services.interfaces;
import com.app.domain.entities.Comment;

public class ICommentService {
    Comment postComment(Long postId, Long userId, String content);
    Comment answerComment(Long answerId, Long userId, String content);
}
