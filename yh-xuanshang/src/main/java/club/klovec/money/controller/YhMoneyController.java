package club.klovec.money.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import club.klovec.common.pojo.YhResult;
import club.klovec.money.service.YhMoneyService;
import club.klovec.pojo.YhXuanshang;

@Controller
public class YhMoneyController {
	@Resource
	private YhMoneyService yhMoneyServiceImpl;
	@RequestMapping("Money/show")
	public String showXuanshang(Model model,HttpServletRequest request){
		 model.addAttribute("msg",yhMoneyServiceImpl.showMes(request));
		 return "xuanshang";
		 
	}
	
	@RequestMapping("Money/insert")
    @ResponseBody
    public YhResult insert(@RequestParam("name") String name,HttpServletRequest request) throws UnsupportedEncodingException {
		YhResult result = new YhResult();
        if(name!=null&&!name.equals("")){
        	name=URLDecoder.decode(name,"UTF-8");
            String[] split = name.split(",");
            YhXuanshang xs = new YhXuanshang();
            xs.setTitle(split[0]);
            xs.setContet(split[1]);
            xs.setPrices(split[2]);
            xs.setLocation(split[3]);
            result = yhMoneyServiceImpl.insXuanshang(xs, request);
        }
        return result;
        
	}
}
