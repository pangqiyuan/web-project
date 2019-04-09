package club.klovec.iteams.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import club.klovec.iteams.service.YhIteamsService;

@Controller
public class YhIteamsController {
	@Resource
	private YhIteamsService yhIteamsServiceImpl;
	
	/**
	 * 显示商品信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("item/{id}.html")
	public String showIteams(@PathVariable Long id,Model model){
		model.addAttribute("item", yhIteamsServiceImpl.selByID(id));
		return "item";
	}
	
	
}
