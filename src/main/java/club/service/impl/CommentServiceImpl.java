package club.service.impl;

import club.dao.CommentMapper;
import club.pojo.Answer;
import club.pojo.Comment;
import club.pojo.Pet;
import club.pojo.User;
import club.service.AnswerService;
import club.service.CommentService;
import club.service.PetService;
import club.service.UserService;
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

    @Resource
    private UserService userService;

    @Resource
    private PetService petService;

    @Resource
    private AnswerService answerService;

    @Override
    public List<Comment> petComments(Integer petId) {
        EntityWrapper wrapper = new EntityWrapper();
        if (petId != null) wrapper.eq("petId", petId);
        List<Comment> comments = commentMapper.selectList(wrapper);
        for (Comment comment : comments){
            User user = userService.findById(comment.getUserId());
            comment.setUser(user);
            Pet pet = petService.findById(comment.getPetId());
            comment.setPet(pet);
            List<Answer> answers = answerService.answersAboutOneComment(comment.getId());
            comment.setAnswer(answers);
        }
        return comments;
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
