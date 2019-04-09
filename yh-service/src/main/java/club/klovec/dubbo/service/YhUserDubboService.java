package club.klovec.dubbo.service;

import club.klovec.pojo.YhUser;

public interface YhUserDubboService {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	YhUser selByUser(YhUser user);
}	
