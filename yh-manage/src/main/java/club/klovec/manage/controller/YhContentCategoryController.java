package club.klovec.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.common.pojo.EasyUITree;
import club.klovec.common.pojo.YhResult;
import club.klovec.manage.service.YhContentCategoryService;
import club.klovec.pojo.YhContentCategory;

@Controller
public class YhContentCategoryController  {
	@Resource
	private YhContentCategoryService yhContentCategoryServiceImpl; 
	/**
	 * 查询网站内容类目
	 * @param id
	 * @return
	 */
	@RequestMapping("content/category/list")
	@ResponseBody
	public List<EasyUITree> showContent(@RequestParam(defaultValue="0")long id){
		return yhContentCategoryServiceImpl.showContent(id);
	}
	
	/**
	 * 新增网站内容类目
	 * @param category
	 * @return
	 */
	@RequestMapping("content/category/create")
	@ResponseBody
	public YhResult create(YhContentCategory category){
		return yhContentCategoryServiceImpl.insContentCategory(category);
	}
	/**
	 * 重命名
	 * @param category
	 * @return
	 */
	@RequestMapping("content/category/update")
	@ResponseBody
	public YhResult update(YhContentCategory category){
		return yhContentCategoryServiceImpl.updateCategory(category);
	}
	/**
	 * 删除
	 * @param category
	 * @return
	 */
	@RequestMapping("content/category/delete")
	@ResponseBody
	public YhResult delete(YhContentCategory category){
		return yhContentCategoryServiceImpl.deleteCategory(category);
	}
	
}
