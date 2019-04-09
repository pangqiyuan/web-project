package club.klovec.search.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.search.service.YhIteamsService;

@Controller
public class YhIteamsController {
	@Resource
	private YhIteamsService yhIteamsServiceImpl;
	
	@RequestMapping(value="solr/init",produces="text/html;charset=utf-8")
	@ResponseBody
	public String init(){
		long start = System.currentTimeMillis();
		try {
			yhIteamsServiceImpl.init();
		long end = System.currentTimeMillis();
		return "初始化总时间"+(start-end)/1000+"秒";
		} catch (Exception e) {
			e.printStackTrace();
			return"初始化失败";
		}
	}
	@RequestMapping("search.html")
	public String selByQuery(Model model,String q,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="12")int rows){
		
		try {
			Map<String, Object> map = yhIteamsServiceImpl.selByQuery(q, page, rows);
			
			model.addAttribute("itemList", map.get("itemList"));
			model.addAttribute("query", q);
			model.addAttribute("totalPages", map.get("totalPages"));
			model.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "search";
		
	}
	
	
	@RequestMapping("solr/add")
	@ResponseBody
	public int add(@RequestBody Map<String,Object> map){
		try {
			 return yhIteamsServiceImpl.insSearch((Map)map.get("iteams"), map.get("desc").toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
