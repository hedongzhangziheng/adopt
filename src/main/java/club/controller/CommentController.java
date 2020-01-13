package club.controller;

import club.pojo.Answer;
import club.pojo.Comment;
import club.pojo.Pet;
import club.pojo.User;
import club.service.AnswerService;
import club.service.CommentService;
import club.service.UserService;
import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private AnswerService answerService;

    @Resource
    private UserService userService;

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
    public Message findById(Integer id){
        Comment comment = commentService.findById(id);
        return Message.success().add("comment", comment);
    }
}
