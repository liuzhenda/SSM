package zhenda_liu.service;

import zhenda_liu.domain.Admin;
import zhenda_liu.domain.Room;

import java.util.List;

//规范和Admin相关的业务接口定义
public interface AdminService {
    //业务目的是添加新管理员
    public boolean regNewAdmin(Admin admin);
    //登录验证
    public boolean loginCheck(Admin admin);
    //获取所有管理员数据
    public List<Admin> selectALL();
    //添加会议室信息
    public boolean regNewRoom(Room room);
}
