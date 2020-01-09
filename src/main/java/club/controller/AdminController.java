package club.controller;

import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

    @RequestMapping("/adopt")
    public String adopt(){
        return "admin/adopt";
    }

    @RequestMapping("/agree")
    public String agree(){
        return "admin/agree";
    }

    @RequestMapping("/apply")
    public String apply(){
        return "admin/apply";
    }

    @RequestMapping("/blog")
    public String blog(){
        return "admin/blog";
    }

    @RequestMapping("/comment")
    public String comment(){
        return "admin/comment";
    }

    @RequestMapping("/disAgree")
    public String disAgree(){
        return "admin/disAgree";
    }

    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }

    @RequestMapping("/pet")
    public String pet(){
        return "admin/pet";
    }

    @RequestMapping("/user")
    public String user(){
        return "admin/user";
    }

}
