package club.service;

import club.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> petComments(Integer petId);
    Integer create(Integer userId, Integer petId, String content);
    Comment findById(Integer id);
}
