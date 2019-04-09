package club.klovec.mapper;

import club.klovec.pojo.YhIteamsCat;
import club.klovec.pojo.YhIteamsCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhIteamsCatMapper {
    int countByExample(YhIteamsCatExample example);

    int deleteByExample(YhIteamsCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhIteamsCat record);

    int insertSelective(YhIteamsCat record);

    List<YhIteamsCat> selectByExample(YhIteamsCatExample example);

    YhIteamsCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhIteamsCat record, @Param("example") YhIteamsCatExample example);

    int updateByExample(@Param("record") YhIteamsCat record, @Param("example") YhIteamsCatExample example);

    int updateByPrimaryKeySelective(YhIteamsCat record);

    int updateByPrimaryKey(YhIteamsCat record);
}