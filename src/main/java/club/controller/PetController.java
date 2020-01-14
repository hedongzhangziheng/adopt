package club.controller;

import club.pojo.Pet;
import club.service.PetService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Resource
    private PetService ps;

    @RequestMapping("/pets")
    @ResponseBody
    public Message pet(@RequestParam(required = false) String petType, @RequestParam("pn")Integer pageNum){
        Integer pageSize = 3;
        if(pageNum==null){
            pageNum = 1;
        }
        PageInfo<Pet> pets = ps.allPet(petType,pageNum,pageSize);
        return Message.success().add("pageInfo",pets );
    }

    @RequestMapping("/create")
    @ResponseBody
    public Message add(Pet pet, MultipartFile file){
        String pic = FileLoad.load(file);
        pet.setPic(pic);
        int add = ps.add(pet);
        if(add>0){
            return Message.success();
        }else{
            return Message.fail();
        }

    }

    @RequestMapping("findById")
    @ResponseBody
    public Message findById(Integer id){
        Pet byId = ps.findById(id);
        return Message.success().add("pet",byId);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Message update(Pet pet){
        int update = ps.update(pet);
        if(update>0){
           return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id){
        int del = ps.del(id);
        if(del>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

}
