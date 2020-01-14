package club.service;

import club.pojo.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {
    PageInfo<Comment> allComment(String userName,Integer pn,Integer pageSize);
    List<Comment> petComments(Integer petId);
    Integer create(Integer userId, Integer petId, String content);
    Comment findById(Integer id);
}
