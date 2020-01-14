package club.service;

import club.pojo.Pet;
import com.github.pagehelper.PageInfo;

public interface PetService {
    PageInfo<Pet> allPet(String petType, Integer pageNum, Integer pageSize);
    int add(Pet pet);
    int update(Pet pet);
    Pet findById(Integer id);
    int del(Integer id);
}
