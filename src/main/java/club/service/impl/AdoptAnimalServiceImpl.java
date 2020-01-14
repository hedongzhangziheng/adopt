package club.service.impl;

import club.dao.AdoptAnimalMapper;
import club.dao.PetMapper;
import club.dao.UserMapper;
import club.pojo.AdoptAnimal;
import club.pojo.Pet;
import club.pojo.User;
import club.service.AdoptAnimalService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class AdoptAnimalServiceImpl implements AdoptAnimalService {

    @Resource
    private AdoptAnimalMapper aam;
    @Resource
    private PetMapper pm;
    @Resource
    private UserMapper um;

    @Override
    public PageInfo<AdoptAnimal> all(String adoptTime,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper<AdoptAnimal> wrapper = new EntityWrapper<>();
        if(adoptTime!=null && !"".equals(adoptTime)){
            wrapper.like("adoptTime",adoptTime);
        }
        List<AdoptAnimal> list = aam.selectList(wrapper.eq("state",1));
        for(AdoptAnimal a : list){
            Pet pet = pm.selectById(a.getPetId());
            a.setPet(pet);
            User user = um.selectById(a.getUserId());
            a.setUser(user);
        }
        PageInfo<AdoptAnimal> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int update(Integer id, Integer state) {
        AdoptAnimal adoptAnimal = aam.selectById(id);
        adoptAnimal.setState(state);
        Integer integer = aam.updateById(adoptAnimal);
        return integer;
    }


}
