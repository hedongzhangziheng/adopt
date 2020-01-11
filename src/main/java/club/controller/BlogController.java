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
    public Message blogs(Integer pn){
        Integer pageSize = 3;
        PageInfo<Blog> pageInfo = blogService.blogs(pn, pageSize);
        return Message.success().add("pageInfo", pageInfo);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findById(Integer id){
        Blog blog = blogService.findById(id);
        return Message.success().add("blog", blog);
    }
}
