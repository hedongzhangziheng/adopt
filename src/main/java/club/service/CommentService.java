package club.service;

import club.pojo.Comment;
import com.github.pagehelper.PageInfo;

public interface CommentService {
    PageInfo<Comment> all(String userName, Integer pageNum, Integer pageSize);
    Comment findById(Integer id);
    int update(Comment adoptAnimal);
    int delete(Integer id);
}
