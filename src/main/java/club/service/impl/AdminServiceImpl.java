package club.service.impl;

import club.dao.AdminMapper;
import club.pojo.Admins;
import club.service.AdminService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public PageInfo<Admins> adminPage(String adminName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper wrapper = new EntityWrapper();
        if(adminName != null && !"".equals(adminName)){
            wrapper.like("adminName",adminName);
        }
        List list = adminMapper.selectList(wrapper);
        PageInfo<Admins> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Admins findById(Integer id) {
        return adminMapper.selectById(id);
    }
}
