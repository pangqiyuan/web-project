package club.klovec.mapper;

import club.klovec.pojo.YhContent;
import club.klovec.pojo.YhContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhContentMapper {
    int countByExample(YhContentExample example);

    int deleteByExample(YhContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhContent record);

    int insertSelective(YhContent record);

    List<YhContent> selectByExampleWithBLOBs(YhContentExample example);

    List<YhContent> selectByExample(YhContentExample example);

    YhContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhContent record, @Param("example") YhContentExample example);

    int updateByExampleWithBLOBs(@Param("record") YhContent record, @Param("example") YhContentExample example);

    int updateByExample(@Param("record") YhContent record, @Param("example") YhContentExample example);

    int updateByPrimaryKeySelective(YhContent record);

    int updateByPrimaryKeyWithBLOBs(YhContent record);

    int updateByPrimaryKey(YhContent record);
}