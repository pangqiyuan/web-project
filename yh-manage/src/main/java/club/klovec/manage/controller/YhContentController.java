package club.klovec.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.pojo.YhResult;
import club.klovec.manage.service.YhContentService;
import club.klovec.pojo.YhContent;

@Controller
public class YhContentController  {
	@Resource
	private YhContentService yhContentServiceImpl;
	
	/**
	 * 网站内容分类内容分页显示
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("content/query/list")
	@ResponseBody
	public EasyUIDataGrid showPgae(long categoryId,int page,int rows){
		return yhContentServiceImpl.showContent(categoryId, page, rows);
	}
	
	@RequestMapping("content/save")
	@ResponseBody
	public YhResult save(YhContent yhContent){
		return yhContentServiceImpl.insContent(yhContent);
	}
}
