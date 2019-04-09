package club.klovec.mapper;

import club.klovec.pojo.YhIteamsParamIteams;
import club.klovec.pojo.YhIteamsParamIteamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhIteamsParamIteamsMapper {
    int countByExample(YhIteamsParamIteamsExample example);

    int deleteByExample(YhIteamsParamIteamsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhIteamsParamIteams record);

    int insertSelective(YhIteamsParamIteams record);

    List<YhIteamsParamIteams> selectByExampleWithBLOBs(YhIteamsParamIteamsExample example);

    List<YhIteamsParamIteams> selectByExample(YhIteamsParamIteamsExample example);

    YhIteamsParamIteams selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhIteamsParamIteams record, @Param("example") YhIteamsParamIteamsExample example);

    int updateByExampleWithBLOBs(@Param("record") YhIteamsParamIteams record, @Param("example") YhIteamsParamIteamsExample example);

    int updateByExample(@Param("record") YhIteamsParamIteams record, @Param("example") YhIteamsParamIteamsExample example);

    int updateByPrimaryKeySelective(YhIteamsParamIteams record);

    int updateByPrimaryKeyWithBLOBs(YhIteamsParamIteams record);

    int updateByPrimaryKey(YhIteamsParamIteams record);
}