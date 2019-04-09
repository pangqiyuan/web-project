package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import club.klovec.dubbo.service.YhIteamsCatDubboService;
import club.klovec.mapper.YhIteamsCatMapper;
import club.klovec.pojo.YhIteamsCat;
import club.klovec.pojo.YhIteamsCatExample;

public class YhIteamsCatDubboServiceImpl implements YhIteamsCatDubboService {
	@Resource
	private YhIteamsCatMapper yhIteamsCatMapper;
	
	@Override
	public List<YhIteamsCat> show(long pid) {
		YhIteamsCatExample example = new YhIteamsCatExample();
		example.createCriteria().andParentIdEqualTo(pid);
		
		return yhIteamsCatMapper.selectByExample(example);
	}

	@Override
	public YhIteamsCat selById(long id) {
		return yhIteamsCatMapper.selectByPrimaryKey(id);
	}

}
