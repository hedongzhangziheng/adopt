package club.service;

import club.pojo.User;

public interface UserService {
    User findById(Integer id);
    Integer update(User user);
}
