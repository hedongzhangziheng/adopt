package club.service;

import club.pojo.User;

public interface UserService {
    //登录
    User loginuser(String userName,String password);
    //注册
    int addUser(User user);
    Integer update(User user);
}
