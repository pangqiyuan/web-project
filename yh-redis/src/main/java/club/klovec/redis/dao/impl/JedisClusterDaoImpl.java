package club.klovec.redis.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import club.klovec.redis.dao.JedisClusterDao;
import redis.clients.jedis.JedisCluster;

@Repository
public class JedisClusterDaoImpl implements JedisClusterDao {
	@Resource
	private JedisCluster jedisClusters;
	
	@Override
	public Boolean exists(String key) {
		return jedisClusters.exists(key);
	}

	@Override
	public String get(String key) {
		return jedisClusters.get(key);
	}

	@Override
	public String set(String key, String value) {
		return jedisClusters.set(key, value);
	}

	@Override
	public Long del(String key) {
		return jedisClusters.del(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return jedisClusters.expire(key, seconds);
	}
	
}
