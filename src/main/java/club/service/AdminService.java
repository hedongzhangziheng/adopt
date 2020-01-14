package club.service;

import club.pojo.Admins;
import com.github.pagehelper.PageInfo;


public interface AdminService {
    PageInfo<Admins> allAdmin(String adminsName, int pageNum, int pageSize);
    int add(Admins admins);
    int update(Admins admins);
    Admins findById(Integer id);
    int del(Integer id);
}
