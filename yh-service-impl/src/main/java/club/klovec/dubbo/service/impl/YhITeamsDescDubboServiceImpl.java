package club.klovec.dubbo.service.impl;

import javax.annotation.Resource;

import club.klovec.dubbo.service.YhIteamsDescDubboService;
import club.klovec.mapper.YhIteamsDescMapper;
import club.klovec.pojo.YhIteamsDesc;

public class YhITeamsDescDubboServiceImpl  implements YhIteamsDescDubboService{
	@Resource
	private YhIteamsDescMapper yhIteamsDescMapper; 
	
	@Override
	public int insDesc(YhIteamsDesc desc) {
		return yhIteamsDescMapper.insert(desc);
	}

	@Override
	public YhIteamsDesc selByIteamsID(long itemid) {
		return yhIteamsDescMapper.selectByPrimaryKey(itemid);
	}

}
