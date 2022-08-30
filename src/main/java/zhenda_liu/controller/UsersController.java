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

    @RequestMapping(value = "/list_meeting")
    @ResponseBody
    public MessageAndData list_meeting(HttpServletRequest request){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("USR_SESSION");
        users = userService.GetAllUserInfo(users);
        List<Meeting> meetings = userService.GetMeetingsByUid(users);
        System.out.println("list_meeting-meetings:"+meetings);
        List<ShowMeeting> showMeetings = new ArrayList<>();
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

    @RequestMapping(value = "/JumpToCancel")
    public ModelAndView JumpToCancel(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("------------------------------");
        modelAndView.setViewName("redirect:../cancel.html");
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

    @RequestMapping(value = "/opt")
    @ResponseBody
    public MessageAndData InsertMeeting(Middle_Meeting middle_meeting) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Meeting meeting = new Meeting(); //建立一个会议的实体类用于向数据库中插入信息
        meeting.setMrid(middle_meeting.getMrid());
        meeting.setOuid(userService.GetUidByUname(middle_meeting.getOuname()));
        meeting.setStartt(formatter.parse(middle_meeting.getStartt().replace("T"," ")));
        meeting.setFtime(formatter.parse(middle_meeting.getFtime().replace("T"," ")));
        meeting.setState(0);  //会议室状态设置为审核中
        System.out.println(meeting);
        if(formatter.parse(middle_meeting.getStartt().replace("T"," ")).before(formatter.parse(middle_meeting.getFtime().replace("T"," ")))){
            Meeting meeting_ret = userService.InsertIntoMeetings(meeting);

            System.out.println(meeting_ret);
            if(meeting_ret.getState() == 0){
                MessageAndData messageAndData = MessageAndData.success().add("test","申请成功");
                return messageAndData; 
            } else if (meeting_ret.getState() == 1) {
                MessageAndData messageAndData = MessageAndData.error().add("info","申请失败，原因：开始时间与已有的记录冲突");
                messageAndData.add("meeting",meeting_ret);
                return messageAndData;
            } else if (meeting_ret.getState() == 2) {
                MessageAndData messageAndData = MessageAndData.error().add("info","申请失败，原因：结束时间与已有的记录冲突");
                messageAndData.add("meeting",meeting_ret);
                return messageAndData;
            }else if(meeting_ret.getState() == 3){
                MessageAndData messageAndData = MessageAndData.error().add("info","申请失败，原因：开始与结束时间与已有的记录冲突");
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
