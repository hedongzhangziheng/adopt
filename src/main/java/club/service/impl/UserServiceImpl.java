package club.service.impl;

import club.dao.UserMapper;
import club.pojo.User;
import club.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User loginuser(String userName,String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        if (user != null && user.getPassword().equals(password)){
            User user1 = userMapper.selectOne(user);
            System.out.println(user1);
            return user1;
        }
        return null;
    }
}
