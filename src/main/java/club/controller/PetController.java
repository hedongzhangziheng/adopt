package club.controller;

import club.pojo.Pet;
import club.service.PetService;
import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Resource
    private PetService petService;

    @RequestMapping("/pets")
    @ResponseBody
    public Message pets(Integer pn){
        return Message.success();
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findPetById(Integer id){
        return Message.success();
    }

    @RequestMapping("/create")
    @ResponseBody
    public Message create(Pet pet){
        Integer integer = petService.create(pet);
        if(integer > 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }
}
