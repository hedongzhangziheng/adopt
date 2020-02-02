package club.service;

import club.pojo.User;

import club.pojo.User;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface UserService {
    List<User> findByName(String userName, Integer state);
    List<User> showName(String userName);
    //登录
    User loginuser(String userName,String password);
    //注册
    int add(User user);
    //修改
    Integer update(User user);
    User findById(Integer id);
    PageInfo<User> allUser(String userName, Integer pageNum, Integer pageSize);
    int del(Integer id);
}
