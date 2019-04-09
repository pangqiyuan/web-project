package club.klovec.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.pojo.YhResult;
import club.klovec.dubbo.service.YhIteamsCatDubboService;
import club.klovec.dubbo.service.YhIteamsParamDubboService;
import club.klovec.manage.pojo.YhIteamsParamChild;
import club.klovec.manage.service.YhIteamsParamService;
import club.klovec.pojo.YhIteamsParam;

@Service
public class YhIteamsParamServiceImpl implements YhIteamsParamService {
	@Reference
	private YhIteamsParamDubboService  yhIteamsParamDubboServiceImpl;
	@Reference
	private YhIteamsCatDubboService  yhIteamsCatDubboServiceImpl;
	@Override
	public EasyUIDataGrid showPage(int page, int rows) {
		EasyUIDataGrid dataGrid = yhIteamsParamDubboServiceImpl.showPage(rows, page);
		List<YhIteamsParam> list =  (List<YhIteamsParam>) dataGrid.getRows();
		List<YhIteamsParamChild> listChild = new ArrayList<YhIteamsParamChild>();
		for (YhIteamsParam param : list) {
			YhIteamsParamChild child = new YhIteamsParamChild();
			
			child.setCreated(param.getCreated());
			child.setId(param.getId());
			child.setItemCatId(param.getItemCatId());
			child.setParamData(param.getParamData());
			child.setUpdated(param.getUpdated());
			child.setItemCatName(yhIteamsCatDubboServiceImpl.selById(param.getItemCatId()).getName());
			
			listChild.add(child);
		}
		
		dataGrid.setRows(listChild);
		return  dataGrid;
	}
	@Override
	public int delByIds(String ids) throws Exception {
		return yhIteamsParamDubboServiceImpl.delByIds(ids);
	}
	@Override
	public YhResult showParam(long catid) {
		YhResult result = new YhResult();
		YhIteamsParam yhIteamsParam = yhIteamsParamDubboServiceImpl.selByCatId(catid);
		if(yhIteamsParam != null){
			result.setStatus(200);
			result.setData(yhIteamsParam);
		}
		return result;
	}
	@Override
	public YhResult  saveParam(YhIteamsParam param) throws Exception {
		Date data = new Date();
		param.setCreated(data);
		param.setUpdated(data);
		int index = yhIteamsParamDubboServiceImpl.insParam(param);
		YhResult result = new YhResult();
		if(index>0){
			result.setStatus(200);
		}
		return result;
	}
	
	
	
}
