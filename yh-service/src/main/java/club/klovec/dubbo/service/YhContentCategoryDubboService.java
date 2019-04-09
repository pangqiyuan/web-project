package club.klovec.dubbo.service;

import java.util.List;

import club.klovec.pojo.YhContentCategory;

public interface YhContentCategoryDubboService {
	
	/**
	 * 根据内容类目id查询所有类目
	 * @param id
	 * @return
	 */
	List<YhContentCategory> showTree(long id);
	
	
	/**
	 * 新增网站内容分类
	 * @param yhContentCategory
	 * @return
	 */
	int insYhContentCategory(YhContentCategory yhContentCategory); 
	
	/**
	 * 更新是否为父菜单属性
	 * @param yhContentCategory
	 * @return
	 */
	int updIsParentByID(YhContentCategory yhContentCategory);
	
	
	/**
	 * 查询菜单的信息
	 * @param id
	 * @return
	 */
	YhContentCategory selByID(long id);
	
}
