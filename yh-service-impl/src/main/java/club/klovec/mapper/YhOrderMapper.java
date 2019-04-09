package club.klovec.mapper;

import club.klovec.pojo.YhOrder;
import club.klovec.pojo.YhOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhOrderMapper {
    int countByExample(YhOrderExample example);

    int deleteByExample(YhOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(YhOrder record);

    int insertSelective(YhOrder record);

    List<YhOrder> selectByExample(YhOrderExample example);

    YhOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") YhOrder record, @Param("example") YhOrderExample example);

    int updateByExample(@Param("record") YhOrder record, @Param("example") YhOrderExample example);

    int updateByPrimaryKeySelective(YhOrder record);

    int updateByPrimaryKey(YhOrder record);
}