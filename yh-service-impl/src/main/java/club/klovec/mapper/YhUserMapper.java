package club.klovec.mapper;

import club.klovec.pojo.YhUser;
import club.klovec.pojo.YhUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhUserMapper {
    int countByExample(YhUserExample example);

    int deleteByExample(YhUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhUser record);

    int insertSelective(YhUser record);

    List<YhUser> selectByExample(YhUserExample example);

    YhUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhUser record, @Param("example") YhUserExample example);

    int updateByExample(@Param("record") YhUser record, @Param("example") YhUserExample example);

    int updateByPrimaryKeySelective(YhUser record);

    int updateByPrimaryKey(YhUser record);
}