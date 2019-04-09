package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import club.klovec.dubbo.service.YhContentCategoryDubboService;
import club.klovec.mapper.YhContentCategoryMapper;
import club.klovec.pojo.YhContentCategory;
import club.klovec.pojo.YhContentCategoryExample;

public class YhContentCategoryDubboServiceImpl implements YhContentCategoryDubboService{
	@Resource
	private YhContentCategoryMapper yhContentCategoryMapper;
	
	@Override
	public List<YhContentCategory> showTree(long id) {
		YhContentCategoryExample example = new YhContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(id).andStatusEqualTo(1);
		return yhContentCategoryMapper.selectByExample( example); 
	}

	@Override
	public int insYhContentCategory(YhContentCategory yhContentCategory) {
		return yhContentCategoryMapper.insert(yhContentCategory);
	}

	@Override
	public int updIsParentByID(YhContentCategory yhContentCategory) {
		return yhContentCategoryMapper.updateByPrimaryKeySelective(yhContentCategory);
	}

	@Override
	public YhContentCategory selByID(long id) {
		return yhContentCategoryMapper.selectByPrimaryKey(id);
	}
	
}
