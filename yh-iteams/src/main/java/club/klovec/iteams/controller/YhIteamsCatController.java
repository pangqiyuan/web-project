package club.klovec.iteams.controller;

import javax.annotation.Resource;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.iteams.pojo.PortalMenu;
import club.klovec.iteams.service.YhIteamsCatService;

@Controller
public class YhIteamsCatController {
	@Resource
	private YhIteamsCatService yhIteamsCatServiceImpl; 
	/**
	 * 返回jsonp数据格式，显示所有菜单
	 * @param callback
	 * @return
	 */
	@RequestMapping("rest/itemcat/all")
	@ResponseBody
	public MappingJacksonValue showMenu(String callback){
		 PortalMenu menu = yhIteamsCatServiceImpl.showMenu();
		 MappingJacksonValue jacksonValue = new MappingJacksonValue(menu);
		 jacksonValue.setJsonpFunction(callback);
		 return jacksonValue;
	}
	
}

