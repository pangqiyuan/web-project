package club.klovec.password.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.common.pojo.YhResult;
import club.klovec.password.service.YhUserService;
import club.klovec.pojo.YhUser;

@Controller
public class YhUserController {
	@Resource
	private YhUserService yhUserServiceImpl;
	
	/**
	 * 显示登录界面
	 * @param url
	 * 点击登录前所在的地址
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/showLogin")
	public String showLogin(String url,Model model){
		model.addAttribute("redirect", url);
		return "login";
	}
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping("user/login")
	@ResponseBody
	public YhResult login(YhUser user,HttpServletRequest request,HttpServletResponse response){
		return yhUserServiceImpl.login(user,request,response);
	}
	
	/**
	 * 通过token(uuid)显示用户信息
	 * @param token
	 * @param callback
	 * @return
	 */
	@RequestMapping("user/token/{token}")
	@ResponseBody
	public Object showUser(@PathVariable String token,@RequestParam(defaultValue="")String callback){
		YhResult result = yhUserServiceImpl.showMes(token);
		if(!callback.equals("")&&callback!=null){
			MappingJacksonValue value =new MappingJacksonValue(result);
			value.setJsonpFunction(callback);
			return value;
		}
		return result;
	}
	
	/**
	 * 用户退出
	 * @param token
	 * @param callback
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("user/logout/{token}")
	@ResponseBody
	public Object logout(@PathVariable String token,String callback,HttpServletRequest request,HttpServletResponse response){
		YhResult result = yhUserServiceImpl.logout(token,request,response);
		if(!callback.equals("")&&callback!=null){
			MappingJacksonValue value =new MappingJacksonValue(result);
			value.setJsonpFunction(callback);
			return value;
		}
		return result;
	}
	
	
	@RequestMapping("/user/showRegister")
	public String showre(String url,Model model){
		model.addAttribute("redirect", url);
		return "register";
	}
}
