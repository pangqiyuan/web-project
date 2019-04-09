package club.klovec.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.util.JsonUtil;
import club.klovec.dubbo.service.YhContentDubboService;
import club.klovec.pojo.YhContent;
import club.klovec.portal.service.YhContentService;
import club.klovec.redis.dao.JedisClusterDao;

@Service
public class YhContentServiceImpl implements YhContentService {
	@Reference
	private YhContentDubboService yhContentServiceImpl;
	@Resource
	private JedisClusterDao jedisClusterDaoImpl;
	@Value("${reids.bigPic.key}")
	private String key;
	
	@Override
	public String showBigPic() {
		if(jedisClusterDaoImpl.exists(key)){
			String string = jedisClusterDaoImpl.get(key);
			if(string != null && !string.equals("")){
				return string;
			}
		}
		
		List<YhContent> list = yhContentServiceImpl.selByCount(6, true);
			
		List<Map<String,Object>> listResult = new ArrayList<>();
		for (YhContent yhContent : list) {
			Map<String,Object> map = new HashMap<>();
			map.put("srcB",yhContent.getPic2() );
			map.put("height",240 );
			map.put("alt","加载失败" );
			map.put("width",670 );
			map.put("src", yhContent.getPic());
			map.put("widthB",550 );
			map.put("href", yhContent.getUrl());
			map.put("heightB", 240);
			listResult.add(map);
		}
		String toJson = JsonUtil.objectToJson(listResult);
		jedisClusterDaoImpl.set(key, toJson);
		return toJson;
	}
 
}
