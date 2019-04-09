package club.klovec.order.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import club.klovec.order.service.YhOrderService;

@Controller
public class OrderController {
	@Resource
	private YhOrderService yhOrderServiceImpl;
	
	@RequestMapping("order/order-cart")
	public String showOrder(Model model, long id){
		model.addAttribute("cartList",yhOrderServiceImpl.selById(id));
		return "order-cart"; 
	}
	
	
}
