package club.klovec.mapper;

import club.klovec.pojo.YhIteamsParam;
import club.klovec.pojo.YhIteamsParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhIteamsParamMapper {
    int countByExample(YhIteamsParamExample example);

    int deleteByExample(YhIteamsParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhIteamsParam record);

    int insertSelective(YhIteamsParam record);

    List<YhIteamsParam> selectByExampleWithBLOBs(YhIteamsParamExample example);

    List<YhIteamsParam> selectByExample(YhIteamsParamExample example);

    YhIteamsParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhIteamsParam record, @Param("example") YhIteamsParamExample example);

    int updateByExampleWithBLOBs(@Param("record") YhIteamsParam record, @Param("example") YhIteamsParamExample example);

    int updateByExample(@Param("record") YhIteamsParam record, @Param("example") YhIteamsParamExample example);

    int updateByPrimaryKeySelective(YhIteamsParam record);

    int updateByPrimaryKeyWithBLOBs(YhIteamsParam record);

    int updateByPrimaryKey(YhIteamsParam record);
}