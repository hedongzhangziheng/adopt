package club.controller;

import club.pojo.Comment;
import club.service.CommentService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @RequestMapping("/comments")
    @ResponseBody
    public Message comments(String userName, Integer pn){
        Integer pageSize = 5;
        if(pn == 0){
            pn = 1;
        }
        PageInfo<Comment> pageInfo = commentService.allComment(userName, pn, pageSize);
        return Message.success().add("pageInfo",pageInfo);
    }
}
