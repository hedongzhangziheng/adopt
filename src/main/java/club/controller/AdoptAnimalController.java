package club.controller;

import club.pojo.AdoptAnimal;
import club.pojo.Pet;
import club.pojo.User;
import club.service.AdoptAnimalService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/create")
    @ResponseBody
    public Message create(HttpSession session){
        User user = (User) session.getAttribute("user");
        Pet pet = (Pet) session.getAttribute("pet");
        pet.setState(1);
        AdoptAnimal adoptAnimal = new AdoptAnimal();
        adoptAnimal.setUserId(user.getId());
        adoptAnimal.setPetId(pet.getId());
        adoptAnimal.setAdoptTime(new Date());
        adoptAnimal.setState(1);
        adoptAnimalService.create(adoptAnimal);
        return Message.success();
    }
}
