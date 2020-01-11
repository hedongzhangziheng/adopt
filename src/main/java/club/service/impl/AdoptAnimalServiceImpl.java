package club.service.impl;

import club.dao.AdoptAnimalMapper;
import club.pojo.AdoptAnimal;
import club.service.AdoptAnimalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdoptAnimalServiceImpl implements AdoptAnimalService {

    @Resource
    private AdoptAnimalMapper adoptAnimalMapper;

    @Override
    public Integer create(AdoptAnimal adoptAnimal) {
        return adoptAnimalMapper.insert(adoptAnimal);
    }
}
