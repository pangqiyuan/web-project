package club.klovec.mapper;

import club.klovec.pojo.YhOrderIteams;
import club.klovec.pojo.YhOrderIteamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhOrderIteamsMapper {
    int countByExample(YhOrderIteamsExample example);

    int deleteByExample(YhOrderIteamsExample example);

    int deleteByPrimaryKey(String id);

    int insert(YhOrderIteams record);

    int insertSelective(YhOrderIteams record);

    List<YhOrderIteams> selectByExample(YhOrderIteamsExample example);

    YhOrderIteams selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YhOrderIteams record, @Param("example") YhOrderIteamsExample example);

    int updateByExample(@Param("record") YhOrderIteams record, @Param("example") YhOrderIteamsExample example);

    int updateByPrimaryKeySelective(YhOrderIteams record);

    int updateByPrimaryKey(YhOrderIteams record);
}