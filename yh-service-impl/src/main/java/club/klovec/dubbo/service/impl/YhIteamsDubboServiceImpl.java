package club.klovec.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.dubbo.service.YhIteamsDubboService;
import club.klovec.mapper.YhIteamsDescMapper;
import club.klovec.mapper.YhIteamsMapper;
import club.klovec.mapper.YhIteamsParamIteamsMapper;
import club.klovec.pojo.YhIteams;
import club.klovec.pojo.YhIteamsDesc;
import club.klovec.pojo.YhIteamsExample;
import club.klovec.pojo.YhIteamsParamIteams;

public class YhIteamsDubboServiceImpl implements YhIteamsDubboService {
	@Resource
	private YhIteamsMapper yhIteamsMapper;
	@Resource
	private YhIteamsDescMapper yhIteamsDescMapper; 
	@Resource
	private YhIteamsParamIteamsMapper  yhIteamsParamIteamsMapper;  
	@Override
	public EasyUIDataGrid show(int page, int rows) {
		
		// 设置分页条件
		PageHelper.startPage(page, rows);
		
		// 查询全部
		List<YhIteams> example = yhIteamsMapper.selectByExample(new YhIteamsExample());

		
		// 分页代码
		// 封装了所有分页所需的信息
		PageInfo<YhIteams> pageinfo = new PageInfo<>(example);
		
		//放入实体类
		EasyUIDataGrid dataGrid = new EasyUIDataGrid();
		dataGrid.setRows(pageinfo.getList());
		dataGrid.setTotal(pageinfo.getTotal());
		
		return dataGrid;
	}
	@Override
	public int updIteamsStatus(YhIteams yhIteams ) {
		return yhIteamsMapper.updateByPrimaryKeySelective(yhIteams);
	}
	
	/*@Override
	public int insIteams(YhIteams yhIteams) {
		return yhIteamsMapper.insert(yhIteams);
	}*/
	
	@Override
	public int insYhTeams(YhIteams yhIteams, YhIteamsDesc iteamsDesc ,YhIteamsParamIteams yhIteamsParamIteams ) throws Exception {
		int index = 0;
		//事务回滚，当有异常时，spirng-aop会自动进行事务回滚，不报错误
		try {
			index = yhIteamsMapper.insertSelective(yhIteams);
			index += yhIteamsDescMapper.insertSelective(iteamsDesc);
			index += yhIteamsParamIteamsMapper.insertSelective(yhIteamsParamIteams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(index==3){
			return 1;
		}else{
			//手动抛异常，让aop进行事务回滚
			throw new Exception("新增商品失败");
		}
	}
	@Override
	public List<YhIteams> selAllByStatus(byte status) {
		YhIteamsExample example = new YhIteamsExample();
		example.createCriteria().andStatusEqualTo(status);
		return yhIteamsMapper.selectByExample(example);
	}
	@Override
	public YhIteams selByID(long id) {
		return yhIteamsMapper.selectByPrimaryKey(id);
	}
	

}
