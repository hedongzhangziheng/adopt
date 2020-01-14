package club.service;

import club.pojo.Comment;
import com.github.pagehelper.PageInfo;

public interface CommentService {
    PageInfo<Comment> allComment(String userName,Integer pn,Integer pageSize);
}
