package club.service;

import club.pojo.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> answersAboutOneComment(Integer commentId);
    Integer create(Integer userId, Integer commentId, String content);
    Answer findById(Integer id);
    Integer creates(Integer userId, Integer replayrId, String content, Integer commentId);
}
