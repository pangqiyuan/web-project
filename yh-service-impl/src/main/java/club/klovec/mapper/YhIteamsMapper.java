package club.klovec.mapper;

import club.klovec.pojo.YhIteams;
import club.klovec.pojo.YhIteamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhIteamsMapper {
    int countByExample(YhIteamsExample example);

    int deleteByExample(YhIteamsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhIteams record);

    int insertSelective(YhIteams record);

    List<YhIteams> selectByExample(YhIteamsExample example);

    YhIteams selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhIteams record, @Param("example") YhIteamsExample example);

    int updateByExample(@Param("record") YhIteams record, @Param("example") YhIteamsExample example);

    int updateByPrimaryKeySelective(YhIteams record);

    int updateByPrimaryKey(YhIteams record);
}