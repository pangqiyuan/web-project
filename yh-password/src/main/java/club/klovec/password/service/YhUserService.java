package club.klovec.password.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.klovec.common.pojo.YhResult;
import club.klovec.pojo.YhUser;

public interface YhUserService {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	YhResult login(YhUser user,HttpServletRequest request,HttpServletResponse response);

	
	/**
	 * 用户信息获取
	 * @param token
	 * @return
	 */
	YhResult showMes(String token);

	/**
	 * 用户退出
	 * @param token
	 * @param request
	 * @param response
	 * @return
	 */
	YhResult logout(String token,HttpServletRequest request,HttpServletResponse response);
}
