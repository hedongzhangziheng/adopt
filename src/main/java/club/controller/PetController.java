package club.controller;

import club.pojo.Pet;
import club.service.PetService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Resource
    private PetService petService;

    @RequestMapping("/pets")
    @ResponseBody
    public Message pets(Integer pn){
        Integer pageSize = 3;
        PageInfo<Pet> pets = petService.pets(pn, pageSize);
        return Message.success().add("pageInfo", pets);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findPetById(HttpSession session, Integer id){
        Pet pet = petService.findById(id);
        session.setAttribute("pet", pet);
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
