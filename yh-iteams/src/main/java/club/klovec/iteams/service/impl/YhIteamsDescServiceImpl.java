package club.klovec.iteams.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.dubbo.service.YhIteamsDescDubboService;
import club.klovec.iteams.service.YhIteamsDescService;
import club.klovec.redis.dao.JedisClusterDao;

@Service
public class YhIteamsDescServiceImpl implements YhIteamsDescService {
	@Reference
	private YhIteamsDescDubboService yhIteamsDescDubboServiceImpl;
	@Resource
	private JedisClusterDao jedisClusterDaoImpl;
	@Value("${redis.iteamsdesc.key}")
	private String descKey;
	
	@Override
	public String selByID(Long id) {
		String key = descKey+id;
		if (jedisClusterDaoImpl.exists(key)) {
			String string = jedisClusterDaoImpl.get(key);
			if(string!=null&&!string.equals("")){
				return string;
			}
		}
		String iteamsDesc = yhIteamsDescDubboServiceImpl.selByIteamsID(id).getIteamsDesc();
		//放入缓存
		jedisClusterDaoImpl.set(key, iteamsDesc);
		
		return iteamsDesc;
	}

}
