package club.service;

import club.pojo.User;
import com.github.pagehelper.PageInfo;


public interface UserService {
    PageInfo<User> allUser(String userName, Integer pageNum, Integer pageSize);
    int add(User user);
    int update(User user);
    User findById(Integer id);
    int del(Integer id);
}
