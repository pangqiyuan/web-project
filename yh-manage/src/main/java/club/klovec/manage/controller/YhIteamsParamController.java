package club.klovec.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.pojo.YhResult;
import club.klovec.manage.service.YhIteamsParamService;
import club.klovec.pojo.YhIteamsParam;

@Controller
public class YhIteamsParamController {
	@Resource
	private YhIteamsParamService yhIteamsParamServiceImpl;

	/**
	 * 商品模板分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("item/param/list")
	@ResponseBody
	public EasyUIDataGrid showPage(int page, int rows) {
		return yhIteamsParamServiceImpl.showPage(page, rows);
	}

	/**
	 * 删除对应id的商品的模板
	 * @param ids
	 * @return
	 */
	@RequestMapping("item/param/delete")
	@ResponseBody
	public YhResult delParam(String ids) {
		int index = 0;
		YhResult yhResult = new YhResult();
		try {
			index = yhIteamsParamServiceImpl.delByIds(ids);
			if (index == 1) {
				yhResult.setStatus(200);
				return yhResult;
			}

		} catch (Exception e) {
			e.printStackTrace();
			yhResult.setData(e.getMessage());
		}
		return yhResult;
	}

	/**
	 * 根据商品类目id查询规格模板信息
	 *  判断类目是否已经添加模板
	 * 
	 * @param catid
	 * @return
	 */
	@RequestMapping("item/param/query/itemcatid/{catid}")
	@ResponseBody
	public YhResult showParam(@PathVariable long catid) {
		return yhIteamsParamServiceImpl.showParam(catid);
	}

	
	/**
	 * 新增商品模板信息
	 * @param param
	 * @return
	 */
	@RequestMapping("item/param/save/{catid}")
	@ResponseBody
	public YhResult insParam(YhIteamsParam param,@PathVariable long catid) {
		YhResult result = new YhResult();
		try {
			param.setItemCatId(catid);
			result = yhIteamsParamServiceImpl.saveParam(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
