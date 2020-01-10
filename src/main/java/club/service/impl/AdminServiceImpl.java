package club.service.impl;

import club.dao.AdminMapper;
import club.pojo.Admins;
import club.pojo.User;
import club.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admins login(String adminName, String adminPwd) {
        Admins a = new Admins();
        a.setAdminName(adminName);
        Admins admin = adminMapper.selectOne(a);
        if (admin != null && admin.getAdminPwd().equals(adminPwd)){
            return admin;
        }
        return null;
    }
}
