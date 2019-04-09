package club.klovec.manage.service;

import java.util.List;

import club.klovec.common.pojo.EasyUITree;

public interface YhIteamsCatService {
	/**
	 * 根据父菜单id显示所有子菜单
	 * @param pid
	 * @return
	 */
	List<EasyUITree> show(long pid);
}
