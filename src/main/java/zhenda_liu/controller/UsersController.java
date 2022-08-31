package zhenda_liu.controller;


import com.google.protobuf.Message;
import com.google.protobuf.Value;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhenda_liu.domain.*;
import zhenda_liu.service.UserService;
import zhenda_liu.utils.MessageAndData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
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
    /**
    * 该函数的功能是检测注册界面的用户输入状态，并进行相应的弹窗提示
    * 对于已经完成的输入，则进行数据库上的检查，并对相应的信息进行弹窗提示
    **/
    @RequestMapping(value = "/register")
    public void RegisterUsers(Users users, HttpServletResponse response) throws IOException{
        if(users.getUname().length() == 0){
            response.setContentType("text/html;charset=UTF-8");     //这句话不加会导致接下来的汉字是乱码
            response.getWriter().write("<script>alert('用户名不能为空!');location.href='../register.html';</script>");
        }else if(users.getUpsd().length() == 0){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script>alert('密码不能为空!');location.href='../register.html';</script>");
        }else{
            if(users.getUdid() == 0){
                users.setUdid(null);
            }
            boolean b = userService.regNewUser(users);  //判断用户的注册状态
            if(b){
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script>alert('注册成功!');location.href='../index.html';</script>");
            }else{
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script>alert('用户名重复!');location.href='../register.html';</script>");
            }
        }
    }

    /**
     * 该函数的功能是检测用户的登录信息输入状态并进行相应的弹窗提示
     * 同时，利用USR_SESSION保存用户的登录信息，以便以后进行相应的登陆检查
     **/

    @RequestMapping(value = "/login")
    public void login(Users users, HttpSession httpSession,HttpServletResponse response) throws IOException {
        //ModelAndView modelAndView = new ModelAndView();
        if(users.getUname().length() == 0){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script>alert('用户名不能为空!');location.href='../index.html';</script>");
            //modelAndView.setViewName("redirect:../index.html");
        }else if(users.getUpsd().length() == 0){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<script>alert('密码不能为空!');location.href='../index.html';</script>");
            //modelAndView.setViewName("redirect:../index.html");
        }else {
            boolean status = userService.LoginCheck(users);
            System.out.println(status);
            if (status) {
                httpSession.setAttribute("USR_SESSION", users);
                //modelAndView.setViewName("redirect:../users.html");
                response.getWriter().write("<script>location.href='../users.html';</script>");
            } else {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write("<script>alert('账号或密码有误!');location.href='../index.html';</script>");
                //modelAndView.setViewName("redirect:../index.html");
            }
        }
        //return modelAndView;
    }

    /**
     * 该函数的功能是将所有符合用户部门的会议室信息显示到前端*/
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

    /**
     * 该函数的功能是用于用户界面——我的会议显示所有的会议*/
    @RequestMapping(value = "/list_meeting")
    @ResponseBody
    public MessageAndData list_meeting(HttpServletRequest request){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("USR_SESSION");
        users = userService.GetAllUserInfo(users);
        List<Meeting> meetings = userService.GetMeetingsByUid(users);  //通过用户id获取该用户所申请的所有的会议室信息
        System.out.println("list_meeting-meetings:"+meetings);
        List<ShowMeeting> showMeetings = new ArrayList<>();   //ShowMeeting是建立的前端与Meeting之间的中间变量，主要用于一些格式的转换以及用户id与用户名之间的转换
        for(int i = 0; i< meetings.size();i++){
            ShowMeeting showMeeting = new ShowMeeting();
            showMeeting.setMid(meetings.get(i).getMid());
            showMeeting.setMrid(meetings.get(i).getMrid());
            showMeeting.setStartt(simpleDateFormat.format(meetings.get(i).getStartt()));
            showMeeting.setFtime(simpleDateFormat.format(meetings.get(i).getFtime()));
            if(meetings.get(i).getState() == 0){
                showMeeting.setState("审核中");
            }else if (meetings.get(i).getState() == 1){
                showMeeting.setState("通过");
            }else if(meetings.get(i).getState() == 2){
                showMeeting.setState("未通过");
            }
            showMeetings.add(showMeeting);
        }
        System.out.println("list_meeting-showmeetings:"+showMeetings);
        MessageAndData meetinglist = MessageAndData.success().add("meetinglist",showMeetings);
        return meetinglist;
    }


    /**
     * 注意：！！！！！！！！
     * 以下涉及到主界面的跳转函数，但是希望组员们利用8.31日讲的方法，此处的跳转函数随时可能更换
     * 请不要轻易使用
     * 一旦后续更改之后以下大部分函数都有可能失效
     * */
    @RequestMapping(value = "/JumpToReigster")
    public ModelAndView JumpToRegister(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../register.html");
        return modelAndView;
    }

    @RequestMapping(value = "/JumpToLogin")
    public ModelAndView JumpToLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../index.html");
        return modelAndView;
    }

    @RequestMapping(value = "/JumpToCancel")
    public ModelAndView JumpToCancel(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../cancel.html");
        return modelAndView;
    }

    @RequestMapping(value = "/JumpToAdmin")
    public ModelAndView JumpToAdmin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../admin.html");
        return modelAndView;
    }

    @RequestMapping(value = "/JumpToApply")
    public ModelAndView JumpToApply(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../users.html");
        return modelAndView;
    }

    /**
     * 该函数的功能主要是将所有的部门列出，用于注册界面建立部门选择框
    * */
    @RequestMapping(value = "/list_Department")
    @ResponseBody
    public MessageAndData list_Department(){
        List<Department> departments = userService.GetAllDepartments();
        MessageAndData roomslist = MessageAndData.success().add("departmentslist",departments);
        System.out.println(departments);
        return roomslist;
    }

    /**
     * 该方法用于程序保持用户的登录状态，向前端展示当前登陆的用户
     * 以user.html为例
     * 网页右上角的   欢迎回来+用户名依赖该函数实现
     * */
    @RequestMapping(value = "/Keep_Login")
    @ResponseBody
    public Users Keep_Login(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("USR_SESSION");
        return users;
    }


    /**
     * 该函数用于表格中申请按键向模态框传递参数
     * 其中的ids具体请见html
     * */
    @RequestMapping(value = "/opt/{ids}")
    @ResponseBody
    public Room FromIdGet(@PathVariable("ids")String ids){
        int id = Integer.parseInt(ids);
        Room room = userService.GetSelectRoomsByRid(id);
        return room;
    }


    /**
     * 该函数用于模态框输入申请信息后的逻辑操作*/
    @RequestMapping(value = "/opt")
    @ResponseBody
    public MessageAndData InsertMeeting(Middle_Meeting middle_meeting) throws ParseException {
        if(middle_meeting.getFtime().length()==0||middle_meeting.getStartt().length()==0){
            MessageAndData messageAndData = MessageAndData.success().add("info","请输入时间");
            return messageAndData;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Meeting meeting = new Meeting(); //建立一个会议的实体类用于向数据库中插入信息
        meeting.setMrid(middle_meeting.getMrid());
        meeting.setOuid(userService.GetUidByUname(middle_meeting.getOuname()));
        meeting.setStartt(formatter.parse(middle_meeting.getStartt().replace("T"," ")));
        meeting.setFtime(formatter.parse(middle_meeting.getFtime().replace("T"," ")));
        meeting.setState(0);  //会议室状态设置为审核中
        System.out.println(meeting);
        if(formatter.parse(middle_meeting.getStartt().replace("T"," ")).before(formatter.parse(middle_meeting.getFtime().replace("T"," ")))){
            int meeting_ret = userService.InsertIntoMeetings(meeting);
            int meeting_flag = meeting_ret%10;
            meeting_ret = meeting_ret/10;
            Meeting meetingtonotice = userService.SelectMeetingByMid(meeting_ret);
            System.out.println(meeting_flag);
            if(meeting_flag == 0){
                MessageAndData messageAndData = MessageAndData.success().add("info","申请成功");
                return messageAndData; 
            } else if (meeting_flag == 1) {
                MessageAndData messageAndData = MessageAndData.error().add("info","申请失败，原因：开始时间与已有的记录冲突\n已有记录如下:\n"+meetingtonotice.TimeToString());
                messageAndData.add("meeting",meeting_ret);
                return messageAndData;
            } else if (meeting_flag == 2) {
                MessageAndData messageAndData = MessageAndData.error().add("info","申请失败，原因：结束时间与已有的记录冲突\n已有记录如下:\n"+meetingtonotice.TimeToString());
                messageAndData.add("meeting",meeting_ret);
                return messageAndData;
            }else if(meeting_flag == 3){
                MessageAndData messageAndData = MessageAndData.error().add("info","申请失败，原因：开始与结束时间与已有的记录冲突\n已有记录如下:\n"+meetingtonotice.TimeToString());
                messageAndData.add("meeting",meeting_ret);
                return messageAndData;
            }
        }
        else{
            MessageAndData messageAndData = MessageAndData.error().add("info","抱歉，您输入的时间不合理");
            return messageAndData;
        }

        MessageAndData messageAndData = MessageAndData.error();
        return messageAndData;
    }


    //该函数用于用户界面点击退出时，将用户的session信息进行清除
    @RequestMapping(value = "/Remove_User_Login")
    @ResponseBody
    public void Remove_User_Login(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("USR_SESSION");
    }

}
