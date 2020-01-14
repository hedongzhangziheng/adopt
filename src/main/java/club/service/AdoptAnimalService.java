package club.service;

import club.pojo.AdoptAnimal;
import com.github.pagehelper.PageInfo;


public interface AdoptAnimalService {
    PageInfo<AdoptAnimal> all(String adoptTime,Integer pageNum, Integer pageSize);
    int update(Integer id, Integer state);


}
