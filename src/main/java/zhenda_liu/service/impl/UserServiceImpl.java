package zhenda_liu.service.impl;

import org.apache.ibatis.jdbc.Null;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhenda_liu.dao.DepartmentMapper;
import zhenda_liu.dao.MeetingMapper;
import zhenda_liu.dao.RoomMapper;
import zhenda_liu.dao.UsersMapper;
import zhenda_liu.domain.*;
import zhenda_liu.service.UserService;

import java.util.List;

@Service(value = "usersService")
@MapperScan("zhenda_liu.dao")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private MeetingMapper meetingMapper;

    //对员工注册函数的实现

    @Override
    public boolean regNewUser(Users users) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUnameEqualTo(users.getUname());
        System.out.println("---==--===-=-=-=-=-=-=");
        System.out.println(users.getUpsd());

        List<Users> userses = usersMapper.selectByExample(usersExample);
        if(userses.size() > 0){
            //说明有同名用户
            System.out.println("存在同名用户");
            return false;
        }else {
            int i = usersMapper.insertSelective(users);
            System.out.println("成功添加用户");
            return true;
        }
    }

    @Override
    public boolean LoginCheck(Users users) {
        boolean flag = false;
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUnameEqualTo(users.getUname()).andUpsdEqualTo(users.getUpsd());
        List<Users> userses = usersMapper.selectByExample(usersExample);

        if(userses.size() > 0){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Room> GetSelectRooms(Users users) {
        if(users.getUdid() == null){
            List<Room> rooms = roomMapper.selectByExample(null);
            return rooms;
        }
        else{
            RoomExample roomExample = new RoomExample();
            RoomExample.Criteria criteria_room = roomExample.createCriteria();
            criteria_room.andRdidEqualTo(users.getUdid());
            List<Room> rooms = roomMapper.selectByExample(roomExample);
            return rooms;
        }
    }

    @Override
    public List<Users> GetAllUsers() {
        return null;
    }

    @Override
    public List<Department> GetAllDepartments() {
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }

    @Override
    public Users GetAllUserInfo(Users users) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUnameEqualTo(users.getUname()).andUpsdEqualTo(users.getUpsd());
        List<Users> userses= usersMapper.selectByExample(usersExample);
        Users ret_users = userses.get(0);
        System.out.println("=====这是impl======");
        System.out.println(ret_users);
        return ret_users;
    }

    @Override
    public Room GetSelectRoomsByRid(int rid) {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria_room = roomExample.createCriteria();
        criteria_room.andRidEqualTo(rid);
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        Room room = rooms.get(0);
        return room;
    }

    @Override
    public Meeting InsertIntoMeetings(Meeting meeting){
        MeetingExample meetingExample = new MeetingExample();
        MeetingExample.Criteria criteria = meetingExample.createCriteria();
        criteria.andMridEqualTo(meeting.getMrid());

        List<Meeting> meetings = meetingMapper.selectByExample(meetingExample);
        int i = 0;
        int flag = 0;
        int rem = 0;
        for(i=0;i<meetings.size();i++){
            flag = 0;
            //判断时间是否重叠
            if(meeting.getStartt().before(meetings.get(i).getFtime())&&meeting.getStartt().after(meetings.get(i).getStartt())){
                flag = flag+1;
                rem = i;
            }
            if (meeting.getFtime().before(meetings.get(i).getFtime())&&meeting.getFtime().after(meetings.get(i).getStartt())) {
                flag = flag+2;
                rem = i;
            }
            if(flag != 0)
                break;
        }
        if(flag == 0){
            System.out.println("this is insert");
            System.out.println(meeting);
            System.out.println(meeting.getFtime().getClass().toString());
            System.out.println("meeting==="+meeting);
            int sucess = meetingMapper.insertSelective(meeting);
            System.out.println("插入了"+sucess);
        }
        System.out.println("1111");
        Meeting meeting_ret = meetings.get(rem);
        System.out.println("返回meeting_ret");
        System.out.println(meeting_ret);
        return meeting_ret;
    }

    @Override
    public int GetUidByUname(String uname) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria= usersExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        List<Users> userses = usersMapper.selectByExample(usersExample);
        return userses.get(0).getUid();
    }

    @Override
    public List<Meeting> GetMeetingsByUid(Users users) {
        MeetingExample meetingExample = new MeetingExample();
        MeetingExample.Criteria criteria = meetingExample.createCriteria();
        criteria.andOuidEqualTo(users.getUid());

        List<Meeting> meetings = meetingMapper.selectByExample(meetingExample);
        return meetings;
    }

    @Override
    public int DeleteMeetingByMid(int mid) {
        MeetingExample meetingExample = new MeetingExample();
        MeetingExample.Criteria criteria = meetingExample.createCriteria();
        criteria.andMidEqualTo(mid);

        meetingMapper.deleteByExample(meetingExample);
        return 0;
    }
}
