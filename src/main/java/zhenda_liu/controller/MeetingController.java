package zhenda_liu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhenda_liu.service.UserService;
import zhenda_liu.utils.MessageAndData;

@Controller
@RequestMapping(value = "/Meeting")
public class MeetingController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/opt/{ids}")
    @ResponseBody
    public MessageAndData FromIdGet(@PathVariable("ids")String ids){
        int id = Integer.parseInt(ids);
        System.out.println("this is room=========");
        System.out.println(id);
        userService.DeleteMeetingByMid(id);
        MessageAndData messageAndData = MessageAndData.success().add("info","删除成功");
        return messageAndData;
    }
}
