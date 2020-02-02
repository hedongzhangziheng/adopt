package club.controller;

import club.pojo.Answer;
import club.pojo.User;
import club.service.AnswerService;
import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Resource
    private AnswerService answerService;

    @RequestMapping("/create")
    @ResponseBody
    public Message create(HttpSession session, Integer commentId, String content){
        User user = (User) session.getAttribute("user");
        Integer integer = answerService.create(user.getId(), commentId, content);
        if (integer > 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findById(Integer id){
        Answer answer = answerService.findById(id);
        return Message.success().add("answer", answer);
    }

    @RequestMapping("/creates")
    @ResponseBody
    public Message creates(HttpSession session, Integer replayId, String content, Integer commentId){
        User user = (User) session.getAttribute("user");
        Integer integer = answerService.creates(user.getId(), replayId, content, commentId);
        if (integer > 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }
}
