package zhenda_liu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import zhenda_liu.dao.AdminMapper;
import zhenda_liu.domain.Admin;
import zhenda_liu.domain.AdminExample;
import zhenda_liu.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;//自动注入，看到存在管理员时如果有autowired注解修饰，则从ioc容器中取出对象使用
    //此业务是添加一个新管理员
    @Override
    public boolean regNewAdmin(Admin admin) {
        //先查询是否存在该管理员
        //mybatis生成的条件实体类的用法
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAnameEqualTo(admin.getAname());//判断管理员用户名是否重复

        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size() > 0){
            System.out.println("存在此用户");
            return false;
        } else {
            //再将信息插入到 数据库中
            int i = adminMapper.insertSelective(admin);
            System.out.println("成功添加了" + i + "个 admin");
            return false;
        }
    }
}
