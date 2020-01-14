package club.service.impl;

import club.dao.PetMapper;
import club.pojo.Pet;
import club.service.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PetServiceImpl implements PetService {
    @Resource
    private PetMapper petMapper;
    @Override
    public Pet findById(Integer id) {
        return petMapper.selectById(id);
    }
}
