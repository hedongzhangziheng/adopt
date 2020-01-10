package club.controller;

import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping("/blogs")
    @ResponseBody
    public Message blogs(Integer pn){
        return Message.success();
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findById(Integer id){
        return Message.success();
    }
}
