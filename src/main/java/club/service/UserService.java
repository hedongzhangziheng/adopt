package club.service;

import club.pojo.User;

public interface UserService {
    //登录
    User loginuser(String userName,String password);
    //注册
    int addUser(User user);
    //修改
    Integer update(User user);
    User findById(Integer id);
}
