package club.klovec.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.pojo.YhResult;
import club.klovec.manage.service.YhIteamsService;
import club.klovec.pojo.YhIteams;

@Controller
public class YhIteamsController {
	@Resource
	private YhIteamsService yhIteamsServiceImpl;
	
	/**
	 * 分页显示商品
	 */
	@RequestMapping("item/list")
	@ResponseBody
	public EasyUIDataGrid show(int page,int rows){
		return yhIteamsServiceImpl.show(page, rows);
	}
	
	/**
	 *编辑页面显示 
	 */
	@RequestMapping("rest/page/item-edit")
	public String showIteamsEdit(){
		return "item-edit";
	}
	
	/**
	 * 商品删除
	 * @param ibs
	 * @return
	 */
	@RequestMapping("rest/item/delete")
	@ResponseBody
	public YhResult delete(String ids){
		YhResult yhResult = new YhResult();
		int index = yhIteamsServiceImpl.update(ids, (byte)3);
		if(index==1){
			yhResult.setStatus(200);
			return yhResult;
		}
		return yhResult;
	}
	
	/**
	 * 商品上架
	 * @param ibs
	 */
	@RequestMapping("rest/item/reshelf")
	@ResponseBody
	public YhResult reshelf(String ids){
		YhResult yhResult = new YhResult();
		int index = yhIteamsServiceImpl.update(ids, (byte)1);
		if(index==1){
			yhResult.setStatus(200);
			return yhResult;
		}
		return yhResult;
	}
	
	/**
	 * 商品下架
	 * @param ibs
	 * @return
	 */
	@RequestMapping("rest/item/instock")
	@ResponseBody
	public YhResult instock(String ids){
		YhResult yhResult = new YhResult();
		int index = yhIteamsServiceImpl.update(ids, (byte)2);
		if(index==1){
			yhResult.setStatus(200);
			return yhResult;
		}
		return yhResult;
	}
	/**
	 * 商品新增
	 * @param yhIteams
	 * @param desc
	 * @return
	 */
	@RequestMapping("item/save")
	@ResponseBody
	public YhResult insert(YhIteams yhIteams,String desc,String itemParams){
		YhResult yhResult = new YhResult();
		int index = 0 ;
		try {
			index = yhIteamsServiceImpl.insert(yhIteams, desc,itemParams);
			if(index==1){
				yhResult.setStatus(200);
				return yhResult;
			}
		} catch (Exception e) {
			e.printStackTrace();
			yhResult.setData(e.getMessage());
		}
		
		return yhResult;
	}
	
}
