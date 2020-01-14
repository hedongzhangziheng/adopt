package club.service;

import club.pojo.Admins;
import com.github.pagehelper.PageInfo;


public interface AdminService {
    PageInfo<Admins> adminPage(String adminName,Integer pageNum,Integer pageSize);
    Admins findById(Integer id);
    Admins login(String adminName, String adminPwd);
}
