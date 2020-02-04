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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Resource
    private PetService petService;

    @RequestMapping("/pets")
    @ResponseBody
    public Message pet(@RequestParam(required = false) String petType, @RequestParam("pn")Integer pageNum){
        Integer pageSize = 3;
        if(pageNum == null){
            pageNum = 1;
        }
        PageInfo<Pet> pets = petService.allPet(petType, pageNum, pageSize);
        return Message.success().add("pageInfo",pets );
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findPetById(HttpSession session, Integer id){
        Pet pet = petService.findById(id);
        String pics = pet.getPic();
        session.setAttribute("pet", pet);
        session.setAttribute("pics", pics);
        return Message.success().add("pet", pet);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Message add(Pet pet, MultipartFile file){
        String pic = FileLoad.uploadPetPic(file);
        pet.setPic(pic);
        int add = petService.add(pet);
        if(add>0){
            return Message.success();
        }else{
            return Message.fail();
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public Message update(Pet pet, MultipartFile file){
        if (file != null && file.getSize() > 0){
            String pic = FileLoad.uploadPetPic(file);
            pet.setPic(pic);
        }
        int update = petService.update(pet);
        if(update>0){
           return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id){
        int del = petService.del(id);
        if(del>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

}
