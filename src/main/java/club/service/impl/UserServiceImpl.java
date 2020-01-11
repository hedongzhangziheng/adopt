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
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public Integer update(User user) {
        return userMapper.updateById(user);
    }
}
