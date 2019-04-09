package club.klovec.mapper;

import club.klovec.pojo.YhContentCategory;
import club.klovec.pojo.YhContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhContentCategoryMapper {
    int countByExample(YhContentCategoryExample example);

    int deleteByExample(YhContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhContentCategory record);

    int insertSelective(YhContentCategory record);

    List<YhContentCategory> selectByExample(YhContentCategoryExample example);

    YhContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhContentCategory record, @Param("example") YhContentCategoryExample example);

    int updateByExample(@Param("record") YhContentCategory record, @Param("example") YhContentCategoryExample example);

    int updateByPrimaryKeySelective(YhContentCategory record);

    int updateByPrimaryKey(YhContentCategory record);
}