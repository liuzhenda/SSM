package zhenda_liu.service;

import org.apache.ibatis.annotations.Param;
import zhenda_liu.domain.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getAllDeps();

    //根据部门号获得部门信息
    Department getDepById(@Param("did") Integer did);

    //根据部门名称获得部门信息
    Department getDepByName(String name);

    //添加一个新部门信息
    Integer adddepartment(String name);

    //更改一个部门信息
    Integer updatedep(@Param("id") Integer did, @Param("name") String name);

    //根据部门号删除一个部门信息
    Integer deletedep(Integer did);

}
