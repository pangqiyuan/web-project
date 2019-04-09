package club.klovec.dubbo.service;

import club.klovec.pojo.YhIteamsParamIteams;

public interface YhIteamsParamIteamsDubboService {
	/**
	 * 根据iteamsid查询具体的规格参数
	 * @param iteamsID
	 * @return
	 */
	YhIteamsParamIteams selByIteamsId(long iteamsID);
}
