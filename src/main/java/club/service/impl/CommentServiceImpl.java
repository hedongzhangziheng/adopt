package club.service.impl;

import club.dao.AdminMapper;
import club.dao.CommentMapper;
import club.dao.PetMapper;
import club.dao.UserMapper;
import club.pojo.*;
import club.service.CommentService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper cm;
    @Resource
    private UserMapper um;
    @Resource
    private PetMapper pm;
    @Resource
    private AdminMapper am;
    @Override
    public PageInfo<Comment> all(String userName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper<Comment> wrapper = new EntityWrapper<>();
        if(userName!=null&&!"".equals(userName)){
            wrapper.like("userName",userName);

        }
        List<Comment> list = cm.selectList(wrapper);
        for(Comment a : list){
            Pet pet = pm.selectById(a.getPetId());
            a.setPet(pet);
            User user = um.selectById(a.getUserId());
            a.setUser(user);
            Admins admins = am.selectById(a.getAdminsId());
            a.setAdmin(admins);
        }
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Comment findById(Integer id) {
        return cm.selectById(id);
    }

    @Override
    public int update(Comment adoptAnimal) {
        return cm.updateById(adoptAnimal);
    }

    @Override
    public int delete(Integer id) {
        return cm.deleteById(id);
    }


}
