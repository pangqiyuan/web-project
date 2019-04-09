package club.klovec.manage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.util.HttpClientUtil;
import club.klovec.common.util.IDUtil;
import club.klovec.common.util.JsonUtil;
import club.klovec.dubbo.service.YhIteamsDescDubboService;
import club.klovec.dubbo.service.YhIteamsDubboService;
import club.klovec.manage.service.YhIteamsService;
import club.klovec.pojo.YhIteams;
import club.klovec.pojo.YhIteamsDesc;
import club.klovec.pojo.YhIteamsParamIteams;

@Service
public class YhIteamsServiceImpl implements YhIteamsService {

	@Reference
	private YhIteamsDubboService yhIteamsDubboServiceImpl;
	@Reference
	private YhIteamsDescDubboService yhIteamsDescDubboServiceImpl;
	@Value("${search.url}")
	private String url;
	
	@Override
	public EasyUIDataGrid show(int page, int rows) {
		return yhIteamsDubboServiceImpl.show(page, rows);

	}

	@Override
	public int update(String ids, byte status) {
		int index = 0;
		String[] strings = ids.split(",");
		for (String string : strings) {
			YhIteams yhIteams = new YhIteams();
			yhIteams.setId(Long.parseLong(string));
			yhIteams.setStatus(status);
			index += yhIteamsDubboServiceImpl.updIteamsStatus(yhIteams);
		}
		if (index == strings.length) {
			return 1;
		}
		return 0;
	}

	@Override
	public int insert(YhIteams yhIteams, String desc ,String itemParams) throws Exception {
		// 不带事务回滚的新增服务
		/*
		 * long id = IDUtil.genIteamsName(); Date date = new Date();
		 * yhIteams.setId(id); yhIteams.setCreated(date);
		 * yhIteams.setUpdated(date); yhIteams.setStatus((byte)1); int index =
		 * yhIteamsDubboServiceImpl.insIteams(yhIteams); if(index>0){
		 * YhIteamsDesc iteamsDesc = new YhIteamsDesc();
		 * iteamsDesc.setIteamsId(id); iteamsDesc.setCreated(date);
		 * iteamsDesc.setIteamsDesc(desc); iteamsDesc.setUpdated(date); index +=
		 * yhIteamsDescDubboServiceImpl.insDesc(iteamsDesc);
		 * 
		 * }
		 * 
		 * if(index==2){ return 1; }
		 */

		final YhIteams Iteamsfinal = yhIteams;
		final String   descfinal = desc;
		// dubbo带事务回滚的新增功能
		long id = IDUtil.genIteamsName();
		Date date = new Date();
		yhIteams.setId(id);
		yhIteams.setCreated(date);
		yhIteams.setUpdated(date);
		yhIteams.setStatus((byte) 1);
		
		YhIteamsDesc iteamsDesc = new YhIteamsDesc();
		iteamsDesc.setIteamsId(id);
		iteamsDesc.setCreated(date);
		iteamsDesc.setIteamsDesc(desc);
		iteamsDesc.setUpdated(date);
		
		YhIteamsParamIteams paramIteams = new YhIteamsParamIteams();
		paramIteams.setCreated(date);
		paramIteams.setItemId(id);
		paramIteams.setUpdated(date);
		paramIteams.setParamData(itemParams);
		int index = 0;
		
		index = yhIteamsDubboServiceImpl.insYhTeams(yhIteams, iteamsDesc,paramIteams);
		
		new Thread(){
			public void run(){
				Map<String,Object> map = new HashMap<>();
				map.put("iteams", Iteamsfinal);
				map.put("desc", descfinal);
				HttpClientUtil.doPostJson(url, JsonUtil.objectToJson(map));
			}
			
		}.start();
		
		
		
		return index;
	}

}
