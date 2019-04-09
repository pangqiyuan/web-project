package club.klovec.mapper;

import club.klovec.pojo.YhOrderShipping;
import club.klovec.pojo.YhOrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YhOrderShippingMapper {
    int countByExample(YhOrderShippingExample example);

    int deleteByExample(YhOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(YhOrderShipping record);

    int insertSelective(YhOrderShipping record);

    List<YhOrderShipping> selectByExample(YhOrderShippingExample example);

    YhOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") YhOrderShipping record, @Param("example") YhOrderShippingExample example);

    int updateByExample(@Param("record") YhOrderShipping record, @Param("example") YhOrderShippingExample example);

    int updateByPrimaryKeySelective(YhOrderShipping record);

    int updateByPrimaryKey(YhOrderShipping record);
}