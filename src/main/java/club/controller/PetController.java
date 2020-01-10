package club.controller;

import club.pojo.Pet;
import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pet")
public class PetController {

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
        return Message.success();
    }
}
