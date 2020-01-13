package club.controller;

import club.pojo.Apply;
import club.service.ApplyService;
import club.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    @Resource
    private ApplyService applyService;

    @RequestMapping("/create")
    @ResponseBody
    public Message create(Apply apply){
        apply.setApplyTime(new Date());
        apply.setState(2);
        Integer integer = applyService.create(apply);
        if(integer > 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }
}
