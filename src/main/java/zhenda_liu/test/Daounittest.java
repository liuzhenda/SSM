package zhenda_liu.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zhenda_liu.dao.AdminMapper;
import zhenda_liu.dao.UsersMapper;
import zhenda_liu.domain.Admin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
* dao层单元测试，在普通方法上添加  @Test注解
* */
//单
public class Daounittest {
    @Test
    public void testSelectOneadmin() throws IOException {
        //读取单元测试时使用的mybatis配置文件
        String resource = "mybatisJunitTest.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//当前session自动提交commit
        //通过动态代理生成实现类
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.selectByPrimaryKey(4);
        System.out.println(admin);
    }

//所有
    @Test
    public void testSelectAlladmin() throws IOException {
        //读取单元测试时使用的mybatis配置文件
        String resource = "mybatisJunitTest.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//当前session自动提交commit
        //通过动态代理生成实现类
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> admins = adminMapper.selectByExample(null);
        //                                               查询条件null
        //Admin admin = adminMapper.selectByPrimaryKey(4);
        System.out.println(admins);
    }
}
