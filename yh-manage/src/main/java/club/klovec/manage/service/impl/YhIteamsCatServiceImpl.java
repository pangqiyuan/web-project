package club.klovec.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.EasyUITree;
import club.klovec.dubbo.service.YhIteamsCatDubboService;
import club.klovec.manage.service.YhIteamsCatService;
import club.klovec.pojo.YhIteamsCat;
@Service
public class YhIteamsCatServiceImpl  implements YhIteamsCatService{
	@Reference
	private YhIteamsCatDubboService yhIteamsCatDubboServiceImpl;
	
	@Override
	public List<EasyUITree> show(long pid) {
		List<YhIteamsCat> list = yhIteamsCatDubboServiceImpl.show(pid);
		List<EasyUITree> listTree = new ArrayList<>();
		for (YhIteamsCat cat : list) {
			EasyUITree tree = new EasyUITree();
			tree.setId(cat.getId());
			tree.setText(cat.getName());
			tree.setState(cat.getIsParent()?"closed":"open");
			listTree.add(tree);
			
		}
		return listTree;
	}
	
}
