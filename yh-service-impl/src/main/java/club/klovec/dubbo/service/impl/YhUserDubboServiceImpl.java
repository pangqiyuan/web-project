package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import club.klovec.dubbo.service.YhUserDubboService;
import club.klovec.mapper.YhUserMapper;
import club.klovec.pojo.YhUser;
import club.klovec.pojo.YhUserExample;

public class YhUserDubboServiceImpl implements YhUserDubboService {
	@Resource
	private YhUserMapper yhUserMapper;
	
	@Override
	public YhUser selByUser(YhUser user) {
		YhUserExample example = new YhUserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
		List<YhUser> list = yhUserMapper.selectByExample(example);
		if(list.size()>0 && list!=null){
			return list.get(0);
		}
		return null;
	}

}
