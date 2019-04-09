package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.dubbo.service.YhIteamsParamDubboService;
import club.klovec.mapper.YhIteamsParamMapper;
import club.klovec.pojo.YhIteamsParam;
import club.klovec.pojo.YhIteamsParamExample;

public class YhIteamsParamDubboServiceImpl implements YhIteamsParamDubboService{
	@Resource
	private YhIteamsParamMapper yhIteamsParamMapper;
	
	@Override
	public EasyUIDataGrid showPage(int rows, int page) {
		//设置分页条件
		PageHelper.startPage(page, rows);
		//如果表中有至少一列是text类型，生成的方法为XXXXXXWithBlobs
		//如果使用xxxxxxwithBlobs 则查询的结果中带有Text类型的列，否则，则不带(为了防止效率过低)
		List<YhIteamsParam> list = yhIteamsParamMapper.selectByExampleWithBLOBs(new YhIteamsParamExample());
		
		PageInfo<YhIteamsParam> pageinfo = new PageInfo<>(list);
		
		EasyUIDataGrid dataGrid  = new EasyUIDataGrid();
		dataGrid.setRows(pageinfo.getList());
		dataGrid.setTotal(pageinfo.getTotal());
		return dataGrid;
	}

	@Override
	public int delByIds(String ids) throws Exception {
		int index = 0;
		String[] strings = ids.split(",");
		for (String string : strings) {
			index += yhIteamsParamMapper.deleteByPrimaryKey(Long.parseLong(string));
		}
		if(index == strings.length){
			return 1;
		}else{
			throw new Exception("删除失败，数据可能丢失");
		}
		
	}

	@Override
	public YhIteamsParam selByCatId(long catId) {
		YhIteamsParamExample example = new YhIteamsParamExample();
		example.createCriteria().andItemCatIdEqualTo(catId);
		List<YhIteamsParam> list = yhIteamsParamMapper.selectByExampleWithBLOBs(example);
		if(list.size()>0 &&list != null){
			return list.get(0);
		}
		return  null;
	}

	@Override
	public int insParam(YhIteamsParam param) throws Exception {
		int index = 0;
		try {
			index = yhIteamsParamMapper.insertSelective(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(index == 1){
			return 1;
		}else{
			throw new Exception("新增商品模板失败");
		}
		
	}

	
}
