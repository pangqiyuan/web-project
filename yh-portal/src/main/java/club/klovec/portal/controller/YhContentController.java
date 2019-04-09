package club.klovec.portal.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import club.klovec.portal.service.YhContentService;

@Controller
public class YhContentController  {
	@Resource
	private YhContentService yhContentServiceImpl;
	
	@RequestMapping("showBigPic")
	public String showBigPic(Model model){
		model.addAttribute("ad1", yhContentServiceImpl.showBigPic());	
		return "index";
	}
	
}
