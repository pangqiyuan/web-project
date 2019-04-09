package club.klovec.dubbo.service;

import java.util.List;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.pojo.YhIteams;
import club.klovec.pojo.YhIteamsDesc;
import club.klovec.pojo.YhIteamsParamIteams;

public interface YhIteamsDubboService {
	/**
	 * 商品分页
	 * @param page第几页
	 * @param rows 显示的个数
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	
	
	/**
	 * 根据对象信息 修改对应的状态
	 * @param yhIteams
	 * @return
	 */
	int updIteamsStatus(YhIteams yhIteams );
	
	
	/**
	 * 不带事务回滚的新增商品
	 * @param yhIteams
	 * @return
	 *
	int insIteams(YhIteams yhIteams);
	/
	
	/**
	 * 带事务回滚的商品新增
	 * @param yhIteams
	 * @param iteamsDesc
	 * @param yhIteamsParamIteams
	 * @return
	 */
	int insYhTeams(YhIteams yhIteams,YhIteamsDesc iteamsDesc,YhIteamsParamIteams yhIteamsParamIteams) throws Exception;
	
	
	/**
	 * 通过status查询所有可用数据
	 * @param status
	 * @return
	 */
	List<YhIteams> selAllByStatus(byte status);
	
	/**
	 * 根据主键查询对应的信息
	 * @param id
	 * @return
	 */
	YhIteams selByID(long id);


}
