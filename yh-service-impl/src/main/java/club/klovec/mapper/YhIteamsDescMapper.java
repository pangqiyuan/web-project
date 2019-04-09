package club.klovec.mapper;

import club.klovec.pojo.YhIteamsDesc;
import club.klovec.pojo.YhIteamsDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhIteamsDescMapper {
    int countByExample(YhIteamsDescExample example);

    int deleteByExample(YhIteamsDescExample example);

    int deleteByPrimaryKey(Long iteamsId);

    int insert(YhIteamsDesc record);

    int insertSelective(YhIteamsDesc record);

    List<YhIteamsDesc> selectByExampleWithBLOBs(YhIteamsDescExample example);

    List<YhIteamsDesc> selectByExample(YhIteamsDescExample example);

    YhIteamsDesc selectByPrimaryKey(Long iteamsId);

    int updateByExampleSelective(@Param("record") YhIteamsDesc record, @Param("example") YhIteamsDescExample example);

    int updateByExampleWithBLOBs(@Param("record") YhIteamsDesc record, @Param("example") YhIteamsDescExample example);

    int updateByExample(@Param("record") YhIteamsDesc record, @Param("example") YhIteamsDescExample example);

    int updateByPrimaryKeySelective(YhIteamsDesc record);

    int updateByPrimaryKeyWithBLOBs(YhIteamsDesc record);

    int updateByPrimaryKey(YhIteamsDesc record);
}