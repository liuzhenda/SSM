package zhenda_liu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhenda_liu.domain.Department;
import zhenda_liu.domain.DepartmentExample;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    Department getDepByName(String dname);

    Integer adddepartment(String dname);

    List<Department> getAllDeps();

    Department getDepById(Integer did);

    Integer deletedep(Integer did);

    Integer updatedep(Integer did, String dname);

}