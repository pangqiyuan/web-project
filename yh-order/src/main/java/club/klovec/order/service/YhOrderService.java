package club.klovec.order.service;

import java.util.List;

import club.klovec.common.pojo.YhIteamsChild;

public interface YhOrderService {
	/**
	 * 查询对应商品信息
	 * @param id
	 * @return
	 */
	List<YhIteamsChild> selById(long id);
}
