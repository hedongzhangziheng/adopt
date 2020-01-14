package club.service;

import club.pojo.AdoptAnimal;

import club.pojo.AdoptAnimal;
import com.github.pagehelper.PageInfo;

public interface AdoptAnimalService {
    Integer create(AdoptAnimal adoptAnimal);
    PageInfo<AdoptAnimal> allAdoptAnimal(String userName,Integer pageNum,Integer pageSize, Integer state);
}
