package club.service.impl;

import club.dao.PetMapper;
import club.pojo.Pet;
import club.service.PetService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    @Resource
    private PetMapper pm;
    @Override
    public PageInfo<Pet> allPet(String petType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper<Pet> wrapper = new EntityWrapper<>();
        if(petType != null && !"".equals(petType)){
            wrapper.like("petType",petType);
        }
        List<Pet> pets = pm.selectList(wrapper);
        PageInfo<Pet> pageInfo = new PageInfo<>(pets,3);
        return pageInfo;
    }

    @Override
    public int add(Pet pet) {
        return pm.insert(pet);
    }

    @Override
    public int update(Pet pet) {
        return pm.updateById(pet);
    }

    @Override
    public Pet findById(Integer id) {
        return pm.selectById(id);
    }

    @Override
    public int del(Integer id) {
        return pm.deleteById(id);
    }
}
