package zhenda_liu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import zhenda_liu.dao.AdminMapper;
import zhenda_liu.dao.RoomMapper;
import zhenda_liu.domain.Admin;
import zhenda_liu.domain.AdminExample;
import zhenda_liu.domain.Room;
import zhenda_liu.domain.RoomExample;
import zhenda_liu.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;//自动注入，看到存在管理员时如果有autowired注解修饰，则从ioc容器中取出对象使用
    @Autowired
    private RoomMapper roomMapper;
    //此业务是添加一个新管理员
    @Override
    public boolean regNewAdmin(Admin admin) {
        //查询是否存在该管理员
        //mybatis生成的条件实体类的用法
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAnameEqualTo(admin.getAname());//判断管理员用户名是否重复

        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size() > 0){
            System.out.println("存在此管理员");
            return false;
        } else {
            //将信息插入到数据库
            int i = adminMapper.insertSelective(admin);
            System.out.println("成功添加了" + i + "个 管理员");
            return false;
        }
    }

    @Override
    public boolean loginCheck(Admin admin) {
        boolean flag = false;
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAnameEqualTo(admin.getAname()).andApsdEqualTo(admin.getApsd());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size()>0){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Admin> selectALL() {
        List<Admin> admins = adminMapper.selectByExample(null);
        return null;
    }

    @Override
    public boolean regNewRoom(Room room) {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andConfigEqualTo(room.getConfig());//判断会议室是否重复
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        if (rooms.size() > 0) {
            System.out.println("存在此会议室");
            return false;
        } else {
            //将信息插入到数据库
            int i = roomMapper.insertSelective(room);
            System.out.println("成功添加了" + i + "个 会议室");
            return false;
        }
    }
}
