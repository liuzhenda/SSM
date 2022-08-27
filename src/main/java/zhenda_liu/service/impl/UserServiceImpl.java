package zhenda_liu.service.impl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhenda_liu.dao.UsersMapper;
import zhenda_liu.domain.Users;
import zhenda_liu.domain.UsersExample;
import zhenda_liu.service.UserService;

import java.util.List;

@Service(value = "usersService")
@MapperScan("zhenda_liu.dao")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    //对员工注册函数的实现

    @Override
    public boolean regNewUser(Users users) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUnameEqualTo(users.getUname());
        System.out.println("++++++++++++++++");
        System.out.println(users.getUname());
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
    public List<Users> GetAllUsers() {
        List<Users> userses = usersMapper.selectByExample(null);
        return userses;
    }
}
