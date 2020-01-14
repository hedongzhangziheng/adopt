package club.service.impl;

import club.dao.PetMapper;
import club.pojo.Pet;
import club.service.PetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    @Resource
    private PetMapper petMapper;

    @Override
    public PageInfo<Pet> pets(Integer pageNum, Integer pagesize) {
        PageHelper.startPage(pageNum, pagesize);
        List<Pet> pets = petMapper.selectList(null);
        PageInfo<Pet> pageInfo = new PageInfo<Pet>(pets, 3);
        return pageInfo;
    }

    @Override
    public Pet findById(Integer id) {
        return petMapper.selectById(id);
    }

    @Override
    public Integer create(Pet pet) {
        return petMapper.insert(pet);
    }

    @Override
    public PageInfo<Pet> allPet(String petType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EntityWrapper<Pet> wrapper = new EntityWrapper<>();
        if(petType != null && !"".equals(petType)){
            wrapper.like("petType",petType);
        }
        List<Pet> pets = petMapper.selectList(wrapper);
        PageInfo<Pet> pageInfo = new PageInfo<>(pets,3);
        return pageInfo;
    }

    @Override
    public int add(Pet pet) {
        return petMapper.insert(pet);
    }

    @Override
    public int update(Pet pet) {
        return petMapper.updateById(pet);
    }

    @Override
    public int del(Integer id) {
        return petMapper.deleteById(id);
    }
}
