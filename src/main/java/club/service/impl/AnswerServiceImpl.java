package club.service.impl;

import club.dao.AnswerMapper;
import club.dao.CommentMapper;
import club.dao.UserMapper;
import club.pojo.Answer;
import club.pojo.Comment;
import club.pojo.User;
import club.service.AnswerService;
import club.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Answer> answersAboutOneComment(Integer commentId) {
        EntityWrapper wrapper = new EntityWrapper();
        if (commentId != null) {
            wrapper.eq("commentId", commentId);
        }
        List<Answer> list = answerMapper.selectList(wrapper);
        if (!list.isEmpty()) {
            for (Answer answer : list) {
                User user = userMapper.selectById(answer.getUserId());
                answer.setUser(user);
                if (answer.getReplayId() != null) {
                    Answer answer1 = answerMapper.selectById(answer.getReplayId());
                    User u = userMapper.selectById(answer1.getUserId());
                    answer1.setUser(u);
                    answer.setAnswer(answer1);
                }
            }
            return list;
        }else {
            return null;
        }
    }

    @Override
    public Integer create(Integer userId, Integer commentId, String content) {
        Answer answer = new Answer();
        answer.setUserId(userId);
        answer.setCommentId(commentId);
        answer.setContent(content);
        answer.setAnswerTime(new Date());
        return answerMapper.insert(answer);
    }

    @Override
    public Answer findById(Integer id) {
        Answer answer = answerMapper.selectById(id);
        Comment comment = commentMapper.selectById(answer.getCommentId());
        answer.setComment(comment);
        return answer;
    }

    @Override
    public Integer creates(Integer userId, Integer replayId, String content, Integer commentId) {
        Answer answer = new Answer();
        answer.setUserId(userId);
        answer.setReplayId(replayId);
        answer.setCommentId(commentId);
        answer.setContent(content);
        answer.setAnswerTime(new Date());
        return answerMapper.insert(answer);
    }

}
