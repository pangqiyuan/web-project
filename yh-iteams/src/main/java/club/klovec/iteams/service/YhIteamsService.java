package club.klovec.iteams.service;

import club.klovec.common.pojo.YhIteamsChild;

public interface YhIteamsService {
	
	/**
	 * 根据主键查询商品详细信息
	 * @param id
	 * @return
	 */
	YhIteamsChild selByID(long id);
}
