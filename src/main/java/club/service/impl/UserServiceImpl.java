package club.service.impl;

import club.dao.UserMapper;
import club.pojo.User;
import club.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User loginuser(String userName,String password) {
        User user = new User();
        user.setUserName(userName);
        User user1 = userMapper.selectOne(user);
        System.out.println(user1);
        if (user1 != null && user1.getPassword().equals(password)) {
            return user1;
        }
        return null;
    }

    @Override
    public Integer update(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }
}
