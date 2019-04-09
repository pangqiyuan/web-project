package club.klovec.dubbo.service;


import java.util.List;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.pojo.YhContent;

public interface YhContentDubboService {
	/**
	 * 分页查询
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid selPage(long categoryId,int page,int rows);
	
	/**
	 * 网页内容新增
	 * @param yhContent
	 * @return
	 */
	int insYhContent(YhContent yhContent);
	
	
	/**
	 * 查询指定个数的最新网站内容
	 * @param count
	 * @param isSort
	 * @return
	 */
	List<YhContent> selByCount(int count,boolean isSort);
}
