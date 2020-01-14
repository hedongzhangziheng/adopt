package club.service;

import club.dao.AdminMapper;
import club.pojo.Admins;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

public interface AdminService {
    PageInfo<Admins> adminPage(String adminName,Integer pageNum,Integer pageSize);
    Admins findById(Integer id);
}
