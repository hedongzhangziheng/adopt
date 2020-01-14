package club.service;

import club.pojo.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findByName(String userName, Integer state);
    List<User> showName(String userName);
}
