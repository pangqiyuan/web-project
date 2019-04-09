package club.klovec.iteams.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.dubbo.service.YhIteamsCatDubboService;
import club.klovec.iteams.pojo.PortalMenu;
import club.klovec.iteams.pojo.PortalMenuNode;
import club.klovec.iteams.service.YhIteamsCatService;
import club.klovec.pojo.YhIteamsCat;
@Service
public class YhIteamsCatServiceImpl implements YhIteamsCatService {
	@Reference
	private YhIteamsCatDubboService yhIteamsCatDubboServiceImpl; 
	
	@Override
	public PortalMenu showMenu() {
		//查询出所有的一级菜单
		List<YhIteamsCat> list = yhIteamsCatDubboServiceImpl.show(0);
		PortalMenu p = new PortalMenu();
		p.setData(selAllMenu(list));		
		return p;
	}
	
	
	/**
	 * 递归查询出所有菜单
	 * @param list
	 * @return
	 */
	public List<Object> selAllMenu(List<YhIteamsCat> list){
		List<Object> listNode = new ArrayList<Object>();
		
		for (YhIteamsCat yhIteamsCat : list) {
			if(yhIteamsCat.getIsParent()){
				PortalMenuNode portalNode = new PortalMenuNode();
				portalNode.setU("/products/"+yhIteamsCat.getId()+".html");
				portalNode.setN("<a href='/products/"+yhIteamsCat.getId()+".html'>"+yhIteamsCat.getName()+"</a>");
				portalNode.setI(selAllMenu(yhIteamsCatDubboServiceImpl.show(yhIteamsCat.getId())));
				listNode.add(portalNode);
			}else{
				listNode.add("/products/"+yhIteamsCat.getId()+".html|"+yhIteamsCat.getName());
			}
		}
		
		
		return listNode;
	}
	

}
