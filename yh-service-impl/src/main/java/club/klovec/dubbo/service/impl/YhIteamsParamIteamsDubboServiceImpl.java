package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import club.klovec.dubbo.service.YhIteamsParamIteamsDubboService;
import club.klovec.mapper.YhIteamsParamIteamsMapper;
import club.klovec.pojo.YhIteamsParamIteams;
import club.klovec.pojo.YhIteamsParamIteamsExample;

public class YhIteamsParamIteamsDubboServiceImpl implements YhIteamsParamIteamsDubboService {
	@Resource
	private YhIteamsParamIteamsMapper yhIteamsParamIteamsMapper;
	
	@Override
	public YhIteamsParamIteams selByIteamsId(long iteamsID) {
		YhIteamsParamIteamsExample example = new YhIteamsParamIteamsExample();
		example.createCriteria().andItemIdEqualTo(iteamsID);
		List<YhIteamsParamIteams> list = yhIteamsParamIteamsMapper.selectByExampleWithBLOBs(example );
		if(list.size()>0&&list!=null){
			return list.get(0);
		}
		return null;
	}

}
