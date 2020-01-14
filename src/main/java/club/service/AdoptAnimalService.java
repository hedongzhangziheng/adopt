package club.service;

import club.pojo.AdoptAnimal;
import com.github.pagehelper.PageInfo;

public interface AdoptAnimalService {
    PageInfo<AdoptAnimal> allAdoptAnimal(String userName,Integer pageNum,Integer pageSize, Integer state);
}
