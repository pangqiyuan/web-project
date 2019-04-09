package club.klovec.iteams.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.iteams.service.YhIteamsParamIteamsService;

@Controller
public class YhIteamsParamIteamsController {
	@Resource
	private YhIteamsParamIteamsService yhIteamsParamIteamsServiceImpl; 
	
	/**
	 * 显示商品规格参数
	 * @param id
	 * @return
	 */
	@RequestMapping(value="item/param/{id}.html",produces="text/html;charset=utf-8")
	@ResponseBody
	public String param(@PathVariable long id){
		return  yhIteamsParamIteamsServiceImpl.selByIteamsID(id);
	}
}
