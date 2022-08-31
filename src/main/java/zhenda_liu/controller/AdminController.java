package zhenda_liu.controller;

//纳入spring容器中管理，controller和用户之间交互，分离spring，此处采用spring mvc

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zhenda_liu.domain.Admin;
import zhenda_liu.domain.Room;
import zhenda_liu.domain.RoomExample;
import zhenda_liu.domain.Users;
import zhenda_liu.service.AdminService;
import zhenda_liu.utils.MessageAndData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//通过http协议访问controller
@Controller
@RequestMapping (value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "/register")
    public void regNewAdmin(Admin admin, HttpServletResponse response) throws IOException {
        if(admin.getAname().length() == 0){
            response.setContentType("text/html;charset=UTF-8");     //这句话不加会导致接下来的汉字是乱码
            response.getWriter().write("<script>alert('管理员名不能为空!');location.href='../admin.html';</script>");
        }else if(admin.getApsd().length() == 0){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script>alert('密码不能为空!');location.href='../admin.html';</script>");
        }else{

            boolean b = adminService.regNewAdmin(admin);  //判断用户的注册状态
            if(b){
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script>alert('注册成功!');location.href='../adminlogin.html';</script>");
            }else{
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script>alert('管理员名重复!');location.href='../admin.html';</script>");
            }
        }
    }
    //验证管理员登录
    @RequestMapping("/login")
    public ModelAndView  login(Admin admin, HttpSession httpSession){    //modelandview对象是spring封装model和view的容器
        ModelAndView modelAndView = new ModelAndView();


        //调用service进行登录验证
        boolean status = adminService.loginCheck(admin);
        if(status){
            //登录成功
            httpSession.setAttribute("ADMIN_SESSION",admin);
            modelAndView.setViewName("redirect:../room.html");//
        }else{
            //回到登录页面
            modelAndView.setViewName("redirect:../adminlogin.html");     //设置视图页
        }
        return modelAndView;
    }
    @RequestMapping(value = "/JumpToReigster")
    public ModelAndView JumpToRegister(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("------------------------------");
        modelAndView.setViewName("redirect:../admin.html");
        return modelAndView;
    }
    @RequestMapping(value = "/JumpToLogin")
    public ModelAndView JumpToLogin(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("------------------------------");
        modelAndView.setViewName("redirect:../adminlogin.html");
        return modelAndView;
    }






}