package club.controller;

import club.pojo.AdoptAnimal;
import club.service.AdoptAnimalService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("adopt")
public class AdoptAnimalController {
    @Resource
    private AdoptAnimalService adoptAnimalService;

    @RequestMapping("/apply")
    @ResponseBody
    public Message agree(String userName,@RequestParam("pn") Integer pageNum,Integer state){
        Integer pageSize = 5;
        if(pageNum == 0){
            pageNum = 1;
        }
        PageInfo<AdoptAnimal> pageInfo = adoptAnimalService.allAdoptAnimal(userName, pageNum, pageSize, state);
        return Message.success().add("pageInfo",pageInfo);
    }

}
