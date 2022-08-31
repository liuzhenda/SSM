package zhenda_liu.service;

import zhenda_liu.domain.Department;
import zhenda_liu.domain.Meeting;
import zhenda_liu.domain.Room;
import zhenda_liu.domain.Users;

import java.util.List;

public interface UserService {

    //用于判断是否注册新角色
    public boolean regNewUser(Users users);

    //登录检查
    public boolean LoginCheck(Users users);

    //获取所有用户的数据
    public List<Users> GetAllUsers();

    //获取所有会议室数据
    public List<Room> GetSelectRooms(Users users);

    public Room GetSelectRoomsByRid(int rid);

    public List<Department> GetAllDepartments();

    public Users GetAllUserInfo(Users users);

    public int InsertIntoMeetings(Meeting meeting);

    public int GetUidByUname(String uname);

    public List<Meeting> GetMeetingsByUid(Users users);

    public int DeleteMeetingByMid(int mid);

    public Meeting SelectMeetingByMid(int mid);

    //修改一个员工数据

}
