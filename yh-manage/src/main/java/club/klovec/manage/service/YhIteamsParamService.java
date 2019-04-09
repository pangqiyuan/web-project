package club.klovec.manage.service;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.pojo.YhResult;
import club.klovec.pojo.YhIteamsParam;

public interface YhIteamsParamService {
	/**
	 * 商品规格分页
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid showPage(int page,int rows);
	
	/**
	 * 规则参数删除
	 * @param ids
	 * @return
	 */
	int delByIds(String ids) throws Exception;
	
	
	/**
	 * 根据商品类目id查询对应规格信息
	 * @param catid
	 * @return
	 */
	YhResult showParam(long catid);
	
	/**
	 * 新增商品规格模板
	 * @param param
	 * @return
	 */
	YhResult  saveParam(YhIteamsParam param) throws Exception ;
	
}
