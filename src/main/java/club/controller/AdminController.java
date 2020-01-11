package club.controller;

import club.pojo.Admins;
import club.service.AdminService;
import org.apache.ibatis.annotations.Param;
import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

   /* @RequestMapping("/admin")
    public String admin(){
        return "admin/admin";
    }*/

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
        return "admin/admin";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "admin/login";
    }
}
