package club.klovec.money.service;

import javax.servlet.http.HttpServletRequest;

import club.klovec.common.pojo.YhResult;
import club.klovec.pojo.YhXuanshang;

public interface YhMoneyService {
	/**
	 * 新增悬赏
	 * @param xs
	 * @return
	 */
	YhResult insXuanshang(YhXuanshang xs,HttpServletRequest request);
	
	/**
	 * 显示悬赏信息
	 * @param id
	 * @return
	 */
	YhResult showMes(HttpServletRequest request);
	
}
