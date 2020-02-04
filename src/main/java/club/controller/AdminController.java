package club.controller;

import club.pojo.Admins;
import club.service.AdminService;
import club.service.UserService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping("/create")
    @ResponseBody
    public Message add(Admins admins, MultipartFile file){
        String pic = FileLoad.uploadAdminPic(file);
        admins.setPic(pic);
        int add = adminService.add(admins);
        if(add>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public Message findById(Integer id){
        Admins byId = adminService.findById(id);
        return Message.success().add("admin",byId);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Message update(Admins admins, MultipartFile file){
        if (file != null && file.getSize() > 0){
            String pic = FileLoad.uploadAdminPic(file);
            admins.setPic(pic);
        }
        int update = adminService.update(admins);
        if(update>0){
            return  Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id){
        int del = adminService.del(id);
        if(del>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

    @RequestMapping("/admins")
    @ResponseBody
    public Message admins(@RequestParam(required = false) String adminName,@RequestParam("pn") Integer pageNum){
        Integer pageSize = 4;
        if(pageNum == null){
            pageNum = 1;
        }
        PageInfo<Admins> list = adminService.adminPage(adminName, pageNum, pageSize);
        return Message.success().add("pageInfo",list);
    }

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

    @RequestMapping("/pet")
    public String pet(){
        return "admin/pet";
    }

    @RequestMapping("/user")
    public String user(){
        return "admin/user";
    }

    /*管理员登录*/
    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }

    @RequestMapping("/dologin")
    public String doLogin(HttpSession session, String adminName,String adminPwd){
        Admins login = adminService.login(adminName, adminPwd);
        if (login == null){
            session.setAttribute("msg","用户名或密码错误！");
            return "redirect:/admin/login";
        }
            session.setAttribute("admin",login);
        return "redirect:/admin/admin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/login";
    }

    @RequestMapping("/developing")
    public String developing(){
        return "admin/developing";
    }

}
