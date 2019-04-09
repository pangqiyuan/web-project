package club.klovec.redis.dao;

public interface JedisClusterDao {
	/**
	 * 判断是否存在
	 * @param key
	 * @return
	 */
	Boolean exists(String key);
	
	/**
	 * 删除值
	 * @param key
	 * @return
	 */
	Long del(String key);
	
	
	/**
	 * 取值
	 * @param key
	 * @return
	 */
	String get(String key);
	
	/**
	 * 设置值
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key,String value);
	
	
	/**
	 * 设置有效时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	Long expire(String key,int seconds);
}
