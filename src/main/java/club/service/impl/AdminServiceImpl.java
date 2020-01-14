package club.service.impl;

import club.dao.AdminMapper;
import club.pojo.Admins;
import club.pojo.User;
import club.dao.AdminMapper;
import club.pojo.Admins;
import club.service.AdminService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private AdminMapper am;


    @Override
    public PageInfo<Admins> allAdmin(String adminsName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper<Admins> wrapper = new EntityWrapper<>();
        if(adminsName != null && !"".equals(adminsName)){
            wrapper.like("adminsName",adminsName);
        }
        List<Admins> admins = am.selectList(wrapper);
        PageInfo<Admins> pageInfo = new PageInfo<>(admins);
        return pageInfo;
    }

    @Override
    public int add(Admins admins) {
        return am.insert(admins);
    }

    @Override
    public int update(Admins admins) {

        return am.updateById(admins);
    }

    @Override
    public Admins findById(Integer id) {
        return am.selectById(id);
    }

    @Override
    public int del(Integer id) {
        return am.deleteById(id);
    }
}
