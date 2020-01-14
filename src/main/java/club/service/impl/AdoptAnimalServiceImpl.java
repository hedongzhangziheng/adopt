package club.service.impl;

import club.dao.AdoptAnimalMapper;
import club.dao.PetMapper;
import club.dao.UserMapper;
import club.pojo.AdoptAnimal;
import club.pojo.Pet;
import club.pojo.User;
import club.service.AdoptAnimalService;
import club.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdoptAnimalServiceImpl implements AdoptAnimalService {
    @Resource
    private AdoptAnimalMapper adoptAnimalMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private PetMapper petMapper;
    @Resource
    private UserService userService;
    @Override
    public PageInfo<AdoptAnimal> allAdoptAnimal(String userName, Integer pageNum, Integer pageSize, Integer state) {
        List<User> users = userService.findByName(userName, state);
        List<Integer> userIds = new ArrayList<>();
        for (User user : users){
            userIds.add(user.getId());
        }
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper wrapper = new EntityWrapper();
        if (state != null){
            wrapper.eq("state", state);
        }
        if (users != null){
            wrapper.in("userId", userIds);
        }
        List<AdoptAnimal> list = adoptAnimalMapper.selectList(wrapper);
        for(AdoptAnimal a : list){
            User u = userMapper.selectById(a.getUserId());
            a.setUser(u);
            Pet pet = petMapper.selectById(a.getPetId());
            a.setPet(pet);
        }
        PageInfo<AdoptAnimal> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
