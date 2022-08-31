package zhenda_liu.service.impl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhenda_liu.dao.DepartmentMapper;
import zhenda_liu.domain.Department;
import zhenda_liu.service.DepartmentService;

import java.util.List;


@Service(value = "AdminService")
@MapperScan("zhenda_liu.dao")
public class DepartmentServiceImpl implements DepartmentService {
    //注入mapper对象
    @Autowired
    private DepartmentMapper mapper;

    //获取所有部门信息
    @Override
    public List<Department> getAllDeps() {
        return mapper.getAllDeps();
    }


    //根据部门号获得部门信息
    @Override
    public Department getDepById(Integer did) {
        return mapper.getDepById(did);
    }

    //根据部门名称获得部门信息
    @Override
    public Department getDepByName(String dname) {
        return mapper.getDepByName(dname);
    }


    //添加一个新部门信息
    @Override
    public Integer adddepartment(String dname) {
        Department depByName = mapper.getDepByName(dname);
        if (depByName != null) {
            return -1;
        }
        return mapper.adddepartment(dname);
    }

    //更改一个部门信息
    @Override
    public Integer updatedep(Integer did, String dname) {
        return mapper.updatedep(did, dname);
    }


    //根据部门号删除一个部门信息
    @Override
    public Integer deletedep(Integer did) {
        return mapper.deletedep(did);
    }

}
