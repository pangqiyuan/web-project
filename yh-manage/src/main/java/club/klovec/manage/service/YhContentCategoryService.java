package club.klovec.manage.service;

import java.util.List;

import club.klovec.common.pojo.EasyUITree;
import club.klovec.common.pojo.YhResult;
import club.klovec.pojo.YhContentCategory;

public interface YhContentCategoryService {

	/**
	 * 根据id查询具体内容
	 * 
	 * @param id
	 * @return
	 */
	List<EasyUITree> showContent(long id);

	/**
	 * 新增网站内容分类
	 * 
	 * @param yhContentCategory
	 * @return
	 */
	YhResult insContentCategory(YhContentCategory yhContentCategory);
	
	
	/**
	 * 更新网站内容信息
	 * @param yhContentCategory
	 * @return
	 */
	YhResult updateCategory(YhContentCategory yhContentCategory);
	
	/**
	 * 删除网站内容分类信息
	 * @param yhContentCategory
	 * @return
	 */
	YhResult deleteCategory(YhContentCategory yhContentCategory);
	
}
