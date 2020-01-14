package club.controller;

import club.pojo.User;
import club.service.UserService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService us;
    @RequestMapping("/users")
    @ResponseBody
    public Message users(@RequestParam(required = false) String userName, @RequestParam("pn")Integer pageNum){
        Integer pageSize = 5;
        PageInfo<User> users = us.allUser(userName,pageNum,pageSize);
        System.out.println(users.getList());
        return Message.success().add("pageInfo",users);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Message add(User user){
        int add = us.add(user);
        if(add>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public Message findById(Integer id){
        User byId = us.findById(id);
        return Message.success().add("user",byId);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(User user){
        int update = us.update(user);
        return "admin/admin";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id){
        int del = us.del(id);
        if(del>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("/about")
    public String about(){
        return "user/about";
    }

    @RequestMapping("/error")
    public String error(){
        return "user/error";
    }

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping("/personal-info")
    public String personalInfo(){
        return "user/personal-info";
    }

    @RequestMapping("/service")
    public String service(){
        return "user/service";
    }

    @RequestMapping("/show")
    public String show(){
        return "user/show";
    }

    @RequestMapping("/team")
    public String team(){
        return "user/team";
    }

    @RequestMapping("/teamBlog")
    public String teamBlog(){
        return "user/teamBlog";
    }

}
