package club.klovec.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.YhIteamsChild;
import club.klovec.dubbo.service.YhIteamsDubboService;
import club.klovec.order.service.YhOrderService;
import club.klovec.pojo.YhIteams;

@Service
public class YhOrderServiceImpl implements YhOrderService {
	@Reference
	private YhIteamsDubboService yhIteamsDubboServiceImpl;
	
	@Override
	public List<YhIteamsChild> selById(long id) {
		YhIteams iteams = yhIteamsDubboServiceImpl.selByID(id);
		YhIteamsChild child = new YhIteamsChild();
		child.setImages(iteams.getImage().split(","));
		child.setBarcode(iteams.getBarcode());
		child.setPrice(iteams.getPrice());
		child.setId(iteams.getId());
		child.setTitle(iteams.getTitle());
		child.setNum(1);
		child.setSellPoint(iteams.getSellPoint());
		child.setEnough(true);
		List<YhIteamsChild> list = new ArrayList<YhIteamsChild>();
		list.add(child);
		return list;
	}
	
}
