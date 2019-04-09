package club.klovec.mapper;

import club.klovec.pojo.YhXuanshang;
import club.klovec.pojo.YhXuanshangExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhXuanshangMapper {
    int countByExample(YhXuanshangExample example);

    int deleteByExample(YhXuanshangExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YhXuanshang record);

    int insertSelective(YhXuanshang record);

    List<YhXuanshang> selectByExample(YhXuanshangExample example);

    YhXuanshang selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YhXuanshang record, @Param("example") YhXuanshangExample example);

    int updateByExample(@Param("record") YhXuanshang record, @Param("example") YhXuanshangExample example);

    int updateByPrimaryKeySelective(YhXuanshang record);

    int updateByPrimaryKey(YhXuanshang record);
}