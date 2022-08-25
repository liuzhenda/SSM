package zhenda_liu.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhenda_liu.domain.Meeting;
import zhenda_liu.domain.MeetingExample;

public interface MeetingMapper {
    long countByExample(MeetingExample example);

    int deleteByExample(MeetingExample example);

    int deleteByPrimaryKey(Integer mid);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    List<Meeting> selectByExample(MeetingExample example);

    Meeting selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") Meeting record, @Param("example") MeetingExample example);

    int updateByExample(@Param("record") Meeting record, @Param("example") MeetingExample example);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
}