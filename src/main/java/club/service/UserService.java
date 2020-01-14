package club.service;

import club.pojo.User;

import club.pojo.User;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findByName(String userName, Integer state);
    List<User> showName(String userName);
    //登录
    User loginuser(String userName,String password);
    //注册
    int addUser(User user);
    Integer update(User user);
    PageInfo<User> allUser(String userName, Integer pageNum, Integer pageSize);
    int add(User user);
    int del(Integer id);
}
