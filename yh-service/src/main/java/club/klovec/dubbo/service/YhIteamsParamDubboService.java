package club.klovec.dubbo.service;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.pojo.YhIteamsParam;

public interface YhIteamsParamDubboService {
	/**
	 * 商品规格分页
	 * @param rows
	 * @param page
	 * @return
	 */
	EasyUIDataGrid showPage(int rows,int page);
	
	/**
	 * 批量删除规格参数
	 * @param ids
	 * @return
	 */
	int delByIds(String ids) throws Exception;
	
	/**
	 * 根据类目id查询对应规格信息(主要是模板信息 param_data)
	 * @param catId
	 * @return
	 */
	YhIteamsParam selByCatId(long catId);
	
	/**
	 * 根据商品类目id新增模板
	 * @param param
	 * @return
	 */
	int insParam(YhIteamsParam param) throws Exception;
	
}
