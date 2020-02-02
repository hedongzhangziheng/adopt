package club.controller;

import club.pojo.Answer;
import club.pojo.Comment;
import club.service.CommentService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import club.pojo.Pet;
import club.pojo.User;
import club.service.AnswerService;
import club.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private AnswerService answerService;

    @Resource
    private UserService userService;

    @RequestMapping("/comments")
    @ResponseBody
    public Message comments(@RequestParam(required = false) String userName, Integer pn){
        Integer pageSize = 5;
        PageInfo<Comment> pageInfo = commentService.allComment(userName, pn, pageSize);
        return Message.success().add("pageInfo", pageInfo);
    }

    @RequestMapping("/petComments")
    @ResponseBody
    public Message petComments(Integer petId){
        List<Comment> comments = commentService.petComments(petId);
        for (Comment comment : comments){
            List<Answer> answers = answerService.answersAboutOneComment(comment.getId());
            comment.setAnswer(answers);
            User user = userService.findById(comment.getUserId());
            comment.setUser(user);
        }
        return Message.success().add("comment", comments);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Message create(HttpSession session, String content){
        User user = (User) session.getAttribute("user");
        Pet pet = (Pet) session.getAttribute("pet");
        Integer integer = commentService.create(user.getId(), pet.getId(), content);
        if (integer > 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findById(HttpSession session, Integer id){
        Comment comment = commentService.findById(id);
        session.setAttribute("comment", comment);
        return Message.success().add("comment", comment);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Message update(Comment comment){
        int update = commentService.update(comment);
        if(update>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message delete(Integer id){
        int delete = commentService.delete(id);
        if(delete>0){
           return Message.success();
        }else{
           return Message.fail();
        }
    }
}
