package zhenda_liu.controller;


import com.google.protobuf.Message;
import com.google.protobuf.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhenda_liu.domain.Room;
import zhenda_liu.domain.Users;
import zhenda_liu.service.UserService;
import zhenda_liu.utils.MessageAndData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/Users")
public class UsersController {
    @Autowired
    private UserService userService;

/*    @RequestMapping(value = "/register")
    public ModelAndView RegisterUsers(Users users, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        PrintWriter out = null;
        boolean b = userService.regNewUser(users);
        System.out.println(b);
        if(b){
            modelAndView.setViewName("redirect:../index.html");
            response.getWriter().write("<script>alert('注册成功!');</script>");
        }else{
            modelAndView.setViewName("redirect:../index.html");
        }
        return modelAndView;
    }*/

    @RequestMapping(value = "/register")
    public void RegisterUsers(Users users, HttpServletResponse response) throws IOException{
        PrintWriter out = null;
        boolean b = userService.regNewUser(users);
        if(b){
            response.getWriter().write("<script>alert('注册成功!');location.href='../index.html';</script>");
        }else{
            response.getWriter().write("<script>alert('用户名重复!');location.href='../register.html';</script>");
        }
    }


    @RequestMapping(value = "/login")
    public ModelAndView login(Users users, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();

        boolean status = userService.LoginCheck(users);
        System.out.println(status);
        if(status){
            httpSession.setAttribute("USR_SESSION",users);
            modelAndView.setViewName("redirect:../users.html");
        }else{
            modelAndView.setViewName("redirect:../index.html");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public MessageAndData list(){
        List<Room> rooms = userService.GetAllRooms();
        System.out.println("+++++++++++++++++++++");
        System.out.println(rooms);
        MessageAndData roomslist = MessageAndData.success().add("roomslist",rooms);
        return roomslist;
    }

    @RequestMapping(value = "/JumpToReigster")
    public ModelAndView JumpToRegister(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("------------------------------");
        modelAndView.setViewName("redirect:../register.html");
        return modelAndView;
    }

    @RequestMapping(value = "/JumpToLogin")
    public ModelAndView JumpToLogin(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("------------------------------");
        modelAndView.setViewName("redirect:../index.html");
        return modelAndView;
    }
}
