package zhenda_liu.controller;


import com.google.protobuf.Message;
import com.google.protobuf.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhenda_liu.domain.Department;
import zhenda_liu.domain.Room;
import zhenda_liu.domain.Users;
import zhenda_liu.service.UserService;
import zhenda_liu.utils.MessageAndData;

import javax.servlet.http.HttpServletRequest;
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
    public MessageAndData list(HttpServletRequest request){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("USR_SESSION");
        users = userService.GetAllUserInfo(users);
        List<Room> rooms = userService.GetSelectRooms(users);
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

    @RequestMapping(value = "/list_Department")
    @ResponseBody
    public MessageAndData list_Department(){
        List<Department> departments = userService.GetAllDepartments();
        MessageAndData roomslist = MessageAndData.success().add("departmentslist",departments);
        System.out.println(departments);
        return roomslist;
    }

    @RequestMapping(value = "/Keep_Login")
    @ResponseBody
    public Users Keep_Login(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("USR_SESSION");
        return users;
    }


    @RequestMapping(value = "/opt/{ids}")
    @ResponseBody
    public Room FromIdGet(@PathVariable("ids")String ids){
        int id = Integer.parseInt(ids);
        System.out.println("this is room=========");
        System.out.println(id);
        Room room = userService.GetSelectRoomsByRid(id);

        System.out.println(room);
        return room;
    }


    //该函数用于用户界面点击退出时，将用户的session信息进行清除
    @RequestMapping(value = "/Remove_User_Login")
    @ResponseBody
    public void Remove_User_Login(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("USR_SESSION");
    }

}
