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
@RequestMapping("blog")
public class BlogController {
    @Resource
    private BlogService blogService;

    @RequestMapping("/blogs")
    @ResponseBody
    public Message pageInfo(Integer pn){
        Integer pageSize = 3;
        PageInfo<Blog> page = blogService.queryByPage(pn, pageSize);
        return Message.success().add("pageInfo",page);
    }
}
