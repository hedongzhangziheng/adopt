package club.dao;

import club.pojo.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 注册
     * @param user
     * @return
     */
    int addUser(User user);
}
