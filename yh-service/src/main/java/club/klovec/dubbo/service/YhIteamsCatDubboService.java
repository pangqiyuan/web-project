package club.klovec.dubbo.service;

import java.util.List;

import club.klovec.pojo.YhIteamsCat;

public interface YhIteamsCatDubboService {
	/**
	 * 根据父类目id查询所有子类目
	 * @param pid
	 * @return
	 */
	List<YhIteamsCat> show(long pid);
	
	/**
	 * 根据商品类目id查询对应的类目
	 * @param id
	 * @return
	 */
	YhIteamsCat selById(long id);
	
}
