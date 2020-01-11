package club.service.impl;

import club.dao.CommentMapper;
import club.pojo.Comment;
import club.service.CommentService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> petComments(Integer petId) {
        EntityWrapper wrapper = new EntityWrapper();
        if (petId != null) wrapper.eq("pet_id", petId);
        return commentMapper.selectList(wrapper);
    }

    @Override
    public Integer create(Integer userId, Integer petId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setPetId(petId);
        comment.setCommentTime(new Date());
        comment.setContent(content);
        return commentMapper.insert(comment);
    }

    @Override
    public Comment findById(Integer id) {
        return commentMapper.selectById(id);
    }
}
