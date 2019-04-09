package club.klovec.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import club.klovec.manage.service.YhIteamsService;

@Controller
public class PageController {
	
	@Resource
	private YhIteamsService yhIteamsServiceImpl;
	
	@RequestMapping("/")
	public String welcome(){
		return "index";
	}
	@RequestMapping("{page}")
	public String page(@PathVariable String page){
		return page;
	}
	
}
