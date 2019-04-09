package club.klovec.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.EasyUIDataGrid;
import club.klovec.common.pojo.YhResult;
import club.klovec.common.util.JsonUtil;
import club.klovec.dubbo.service.YhContentDubboService;
import club.klovec.manage.service.YhContentService;
import club.klovec.pojo.YhContent;
import club.klovec.redis.dao.JedisClusterDao;
import javassist.expr.NewArray;

@Service
public class YhContentServiceImpl implements YhContentService {
	@Reference
	private YhContentDubboService yhContentDubboServiceImpl;
	@Resource
	private JedisClusterDao jedisClusterDaoImpl;
	@Value("${reids.bigPic.key}")
	private String key;

	@Override
	public EasyUIDataGrid showContent(long categoryId, int page, int rows) {
		return yhContentDubboServiceImpl.selPage(categoryId, page, rows);
	}

	@Override
	public YhResult insContent(YhContent yhContent) {
		YhResult result = new YhResult();
		Date date = new Date();
		yhContent.setCreated(date);
		yhContent.setUpdated(date);
		int index = yhContentDubboServiceImpl.insYhContent(yhContent);
		if (index > 0) {
			result.setStatus(200);
		}

		if (jedisClusterDaoImpl.exists(key)) {
			String string = jedisClusterDaoImpl.get(key);
			if (string != null && !string.equals("")) {
				List<HashMap> list = JsonUtil.jsonToList(string, HashMap.class);

				HashMap<String,Object> map = new HashMap<>();
				map.put("srcB", yhContent.getPic2());
				map.put("height", 240);
				map.put("alt", "加载失败");
				map.put("width", 670);
				map.put("src", yhContent.getPic());
				map.put("widthB", 550);
				map.put("href", yhContent.getUrl());
				map.put("heightB", 240);
				
				if(list.size()==6){
					list.remove(5);
				}
				list.add(0,map);
				
				jedisClusterDaoImpl.set(key, JsonUtil.objectToJson(list));
			}
		}
			
			return result;
	}

}
