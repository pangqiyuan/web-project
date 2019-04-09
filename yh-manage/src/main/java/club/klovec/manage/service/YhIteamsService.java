package club.klovec.manage.service;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.pojo.YhIteams;

public interface YhIteamsService {
	/**
	 * 显示商品
	 * @param page
	 * 			第几页
	 * @param rows
	 * 			一页显示的个数
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	
	
	/**
	 * 根据id更新状态
	 * @param ibs
	 * 			所有id连接在一起的字符串
	 * @param status
	 * @return
	 */
	int update(String ibs,byte status);
	
	
	
	/**
	 * 商品新增(带事务回滚)
	 * @param yhIteams
	 * @param desc
	 * @param itemParams
	 * @return
	 */
	int insert(YhIteams yhIteams,String desc,String itemParams) throws Exception;
}
