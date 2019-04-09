package club.klovec.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.common.pojo.EasyUITree;
import club.klovec.manage.service.YhIteamsCatService;

@Controller
public class YhIteamsCatController {
	@Resource
	private YhIteamsCatService yhIteamsCatServiceImpl;
	/**
	 * 显示商品类目
	 * @param id
	 * @return
	 */
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<EasyUITree> showCat(@RequestParam(defaultValue="0")Long id){
		return yhIteamsCatServiceImpl.show(id);
	}
	
	
}
