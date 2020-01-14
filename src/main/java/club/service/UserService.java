package club.service;

import club.pojo.User;

import club.pojo.User;
import com.github.pagehelper.PageInfo;


public interface UserService {
    //登录
    User loginuser(String userName,String password);
    //注册
    int addUser(User user);
    Integer update(User user);
    PageInfo<User> allUser(String userName, Integer pageNum, Integer pageSize);
    int add(User user);
    int update(User user);
    User findById(Integer id);
    int del(Integer id);
}
