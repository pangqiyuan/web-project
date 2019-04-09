package club.klovec.dubbo.service;

import java.util.List;

import club.klovec.pojo.YhXuanshang;

public interface YhXuanShangDubboService {
	/**
	 * 新增悬赏
	 * @param xs
	 * @return
	 */
	int insXuanShang(YhXuanshang xs);
	
	List<YhXuanshang> showXuanshang(long cid);
	
}
