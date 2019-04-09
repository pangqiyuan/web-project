package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.dubbo.service.YhContentDubboService;
import club.klovec.mapper.YhContentMapper;
import club.klovec.pojo.YhContent;
import club.klovec.pojo.YhContentExample;

public class YhContentDubboServiceImpl implements YhContentDubboService {
	@Resource
	private YhContentMapper yhContentMapper;

	@Override
	public EasyUIDataGrid selPage(long categoryId, int page, int rows) {
		PageHelper.startPage(page, rows);
		YhContentExample example = new YhContentExample();
		if(categoryId !=0 ){
			example.createCriteria().andCategoryIdEqualTo(categoryId);
		}
		List<YhContent> list = yhContentMapper.selectByExampleWithBLOBs(example);
		
		PageInfo<YhContent> pageinfo = new PageInfo<YhContent>(list);
		EasyUIDataGrid dataGrid = new EasyUIDataGrid();
		dataGrid.setRows(pageinfo.getList());
		dataGrid.setTotal(pageinfo.getTotal());
		return dataGrid;
	}

	@Override
	public int insYhContent(YhContent yhContent) {
		return yhContentMapper.insert(yhContent);
	}

	@Override
	public List<YhContent> selByCount(int count, boolean isSort) {
		YhContentExample example = new YhContentExample();
		//排序(降序)
		if(isSort){
			example.setOrderByClause("updated desc");
		}
		if(count !=0 ){
			PageHelper.startPage(1, count);
			List<YhContent> list = yhContentMapper.selectByExampleWithBLOBs(example);
			PageInfo<YhContent> p = new PageInfo<YhContent>(list);
			return p.getList();
		}else{
			return yhContentMapper.selectByExampleWithBLOBs(example);
		}
		
	}
	

}
