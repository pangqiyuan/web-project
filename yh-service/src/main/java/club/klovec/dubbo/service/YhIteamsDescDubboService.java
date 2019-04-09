package club.klovec.dubbo.service;

import club.klovec.pojo.YhIteamsDesc;

public interface YhIteamsDescDubboService {
	/**
	 * 新增商品描述
	 * @param desc
	 * @return
	 */
	int insDesc(YhIteamsDesc desc);
	
	/**
	 * 根据主键查询商品描述对象
	 * @param itemid
	 * @return
	 */
	YhIteamsDesc selByIteamsID(long itemid);
}
