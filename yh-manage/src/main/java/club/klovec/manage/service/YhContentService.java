package club.klovec.manage.service;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.pojo.YhResult;
import club.klovec.pojo.YhContent;

public interface YhContentService {
	/**
	 * 
	 * 网站内容分页显示
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid showContent(long categoryId,int page,int rows);

	/**
	 * 新增
	 * @param yhContent
	 * @return
	 */
	YhResult insContent(YhContent yhContent);
}
