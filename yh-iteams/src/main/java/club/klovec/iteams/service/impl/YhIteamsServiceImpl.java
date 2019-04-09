package club.klovec.iteams.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.YhIteamsChild;
import club.klovec.common.util.JsonUtil;
import club.klovec.dubbo.service.YhIteamsDubboService;
import club.klovec.iteams.service.YhIteamsService;
import club.klovec.pojo.YhIteams;
import club.klovec.redis.dao.JedisClusterDao;

@Service
public class YhIteamsServiceImpl implements YhIteamsService {
	@Reference
	private YhIteamsDubboService yhIteamsDubboServiceImpl;
	@Resource
	private JedisClusterDao jedisClusterDaoImpl;
	@Value("${redis.iteams.key}")
	private String iteamsKey;

	@Override
	public YhIteamsChild selByID(long id) {
		String key = iteamsKey + id;
		if (jedisClusterDaoImpl.exists(key)) {
			String string = jedisClusterDaoImpl.get(key);
			if(string!=null&&!string.equals("")){
				return JsonUtil.jsonToPojo(string, YhIteamsChild.class);
			}
		}

		YhIteams iteams = yhIteamsDubboServiceImpl.selByID(id);
		YhIteamsChild child = new YhIteamsChild();
		if (iteams != null && !iteams.equals("")) {
			child.setId(iteams.getId());
			child.setPrice(iteams.getPrice());
			child.setTitle(iteams.getTitle());
			child.setImages(iteams.getImage() == null && iteams.getImage().equals("") ? new String[1]
					: iteams.getImage().split(","));
			child.setSellPoint(iteams.getSellPoint());
			// 存到redis中
			jedisClusterDaoImpl.set(key, JsonUtil.objectToJson(child));
		}
		return child;
	}

}
