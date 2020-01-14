package club.controller;

import club.pojo.Admins;
import club.service.AdminService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService as;

    @RequestMapping("/admin")
    public String adming(){
        return "admin/admin";
    }

    @RequestMapping("/admins")
    @ResponseBody
    public Message admin(@RequestParam(value = "adminName",required = false) String adminsName, @RequestParam("pn")Integer pageNum){
        Integer pageSize = 3;
        if(pageNum==null){
            pageNum = 1;
        }
        PageInfo<Admins> admins = as.allAdmin(adminsName,pageNum,pageSize);
        return Message.success().add("pageInfo",admins);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Message add(Admins admins){
        int add = as.add(admins);
        if(add>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public Message findById(Integer id){
        Admins byId = as.findById(id);
        return Message.success().add("admin",byId);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Message update(Admins admins){
        int update = as.update(admins);
        if(update>0){
            return  Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id){
        int del = as.del(id);
        if(del>0){
            return Message.success();
        }else {
            return Message.fail();
        }
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
