package club.service;

import club.pojo.Pet;
import com.github.pagehelper.PageInfo;

public interface PetService {
    PageInfo<Pet> pets(Integer pageNum, Integer pagesize);
    Pet findById(Integer id);
    Integer create(Pet pet);
}
