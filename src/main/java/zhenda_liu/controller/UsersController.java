package zhenda_liu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zhenda_liu.domain.Users;
import zhenda_liu.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/Users")
public class UsersController {
    @Autowired
    private UserService userService;



    @RequestMapping(value = "/register")
    public void RegisterUsers(Users users){
        boolean b = userService.regNewUser(users);
        System.out.println(b);
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
}
