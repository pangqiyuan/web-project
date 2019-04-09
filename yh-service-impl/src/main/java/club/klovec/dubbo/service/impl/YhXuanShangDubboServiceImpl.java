package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import club.klovec.dubbo.service.YhXuanShangDubboService;
import club.klovec.mapper.YhXuanshangMapper;
import club.klovec.pojo.YhXuanshang;
import club.klovec.pojo.YhXuanshangExample;

public class YhXuanShangDubboServiceImpl implements YhXuanShangDubboService {
	@Resource
	private YhXuanshangMapper yhXuanshangMapper;
	
	@Override
	public int insXuanShang(YhXuanshang xs) {
		return yhXuanshangMapper.insertSelective(xs);
		
	}

	@Override
	public List<YhXuanshang> showXuanshang(long cid) {
		List<YhXuanshang> list =null;
		YhXuanshangExample example = new YhXuanshangExample();
		if(cid==-1){
			list=yhXuanshangMapper.selectByExample(example);
		}else{
			
			example.createCriteria().andCidEqualTo(cid);
			list = yhXuanshangMapper.selectByExample(example);
		}
		
		return list;
	}

}
