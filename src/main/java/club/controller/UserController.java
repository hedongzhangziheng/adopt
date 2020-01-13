package club.controller;

import club.pojo.User;
import club.service.UserService;
import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/create")
    @ResponseBody
    public Message addUser(HttpSession session,User user){
        int i = userService.addUser(user);
        if (i > 0){
            return Message.success();
        }
        return  Message.fail();
    }

    @RequestMapping("/login")
    @ResponseBody
    public Message loginuser(HttpSession session, String userName, String password){
      /*  System.out.println(userName);
        System.out.println(password);*/
        User user = userService.loginuser(userName, password);
        if (user != null){
            session.setAttribute("user",user);
            return Message.success().add("user",user);
        }else{
            return Message.fail();
        }
    }
    @RequestMapping("/logout")
    @ResponseBody
    public Message logout(HttpSession session){
        session.invalidate();
        return Message.success();
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

    @RequestMapping("/update")
    @ResponseBody
    public Message update(User user){
        Integer update = userService.update(user);
        if(update > 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("/updatePic")
    @ResponseBody
    public Message updatePic(MultipartFile file){
        String fileName = FileLoad.load(file);
        return Message.success();
    }
}
