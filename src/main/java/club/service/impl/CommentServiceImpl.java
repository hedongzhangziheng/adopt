package club.service.impl;

import club.dao.CommentMapper;
import club.pojo.Answer;
import club.dao.PetMapper;
import club.dao.UserMapper;
import club.pojo.Comment;
import club.pojo.Pet;
import club.pojo.User;
import club.service.AnswerService;
import club.pojo.Pet;
import club.pojo.User;
import club.dao.AdminMapper;
import club.pojo.*;
import club.service.CommentService;
import club.service.PetService;
import club.service.UserService;
import club.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private PetMapper petMapper;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private UserService userService;
    @Resource
    private PetService petService;
    @Resource
    private AnswerService answerService;
    @Override
    public PageInfo<Comment> allComment(String userName, Integer pn, Integer pageSize) {
        List<User> users = userService.showName(userName);
        List<Integer> userIds = new ArrayList<>();
        for (User user : users){
            userIds.add(user.getId());
        }
        PageHelper.startPage(pn,pageSize);
        EntityWrapper wrapper = new EntityWrapper();
        if (users != null){
            wrapper.in("userId", userIds);
        }
        List<Comment> list = commentMapper.selectList(wrapper);
        for (Comment comment: list) {
            User u = userMapper.selectById(comment.getUserId());
            comment.setUser(u);
            Pet pet = petMapper.selectById(comment.getPetId());
            comment.setPet(pet);
        }
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Comment> petComments(Integer petId) {
        EntityWrapper wrapper = new EntityWrapper();
        if (petId != null) {
            wrapper.eq("petId", petId);
        }
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

    @Override
    public PageInfo<Comment> all(String userName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper<Comment> wrapper = new EntityWrapper<>();
        if(userName!=null&&!"".equals(userName)){
            wrapper.like("userName",userName);

        }
        List<Comment> list = commentMapper.selectList(wrapper);
        for(Comment a : list){
            Pet pet = petMapper.selectById(a.getPetId());
            a.setPet(pet);
            User user = userMapper.selectById(a.getUserId());
            a.setUser(user);
            Admins admins = adminMapper.selectById(a.getAdminsId());
            a.setAdmin(admins);
        }
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int update(Comment adoptAnimal) {
        return commentMapper.updateById(adoptAnimal);
    }

    @Override
    public int delete(Integer id) {
        return commentMapper.deleteById(id);
    }


}
