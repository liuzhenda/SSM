package zhenda_liu.service;

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
    public List<Room> GetAllRooms();

    //修改一个员工数据

}
