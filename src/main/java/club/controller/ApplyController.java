package club.controller;

import club.pojo.Apply;
import club.service.ApplyService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @RequestMapping("/applys")
    @ResponseBody
    public Message apply(@RequestParam(required = false)Integer state, @RequestParam("pn") Integer pageNum){
        Integer pageSize = 3;
        if(pageNum == 0){
            pageNum = 1;
        }
        PageInfo<Apply> apply = applyService.allApply(state,pageNum,pageSize);
        return Message.success().add("pageInfo",apply);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findByid(Integer id){
        Apply byid = applyService.findByid(id);
        return Message.success().add("apply",byid);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Message update(Apply apply){
        int i = applyService.updateApply(apply);
        if(i > 0){
            return Message.success();
        }
            return Message.fail();
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Message delete(Integer id){
        int i = applyService.del(id);
        if(i > 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }
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
