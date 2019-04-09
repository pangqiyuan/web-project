package club.klovec.iteams.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.iteams.service.YhIteamsDescService;

@Controller
public class YhIteamsDescController {
	@Resource
	private YhIteamsDescService yhIteamsDescServiceImpl;
	/**
	 * 显示商品详情
	 * @param id
	 * @return
	 */
	@RequestMapping("item/desc/{id}.html")
	@ResponseBody
	public String showDesc(@PathVariable Long id){
		return yhIteamsDescServiceImpl.selByID(id);
	}
	
}
