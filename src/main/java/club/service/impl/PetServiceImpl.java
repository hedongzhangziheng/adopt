package club.service.impl;

import club.dao.PetMapper;
import club.pojo.Pet;
import club.service.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
}
