package club.controller;

import club.pojo.Blog;
import club.service.BlogService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;
    @RequestMapping("/blogs")
    @ResponseBody
    public Message queryAll(){
        PageInfo<Blog> blogPageInfo = blogService.queryByPage();
        System.out.println(blogPageInfo);
        return Message.success().add("pageInfo",blogPageInfo);
    }

}
