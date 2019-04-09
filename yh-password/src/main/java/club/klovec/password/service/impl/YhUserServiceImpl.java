package club.klovec.password.service.impl;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.YhResult;
import club.klovec.common.util.CookieUtils;
import club.klovec.common.util.JsonUtil;
import club.klovec.dubbo.service.YhUserDubboService;
import club.klovec.password.service.YhUserService;
import club.klovec.pojo.YhUser;
import club.klovec.redis.dao.JedisClusterDao;

@Service
public class YhUserServiceImpl implements YhUserService {
	@Reference
	private YhUserDubboService YhUserDubboServiceImpl;
	@Resource
	private JedisClusterDao jedisClusterDaoImpl;

	@Override
	public YhResult login(YhUser user, HttpServletRequest request, HttpServletResponse response) {
		YhResult result = new YhResult();
		YhUser yhUser = YhUserDubboServiceImpl.selByUser(user);
		if (yhUser != null && !yhUser.equals("")) {
			result.setStatus(200);
			String key = UUID.randomUUID().toString();
			// 将用户信息存到redis中
			jedisClusterDaoImpl.set(key, JsonUtil.objectToJson(yhUser));
			// 设置有效时间
			jedisClusterDaoImpl.expire(key, 60 * 60 * 24 * 7);
			// 放入cookie中
			CookieUtils.setCookie(request, response, "TT_TOKEN", key, 60 * 60 * 24 * 7);
		} else {
			result.setMsg("用户名或密码错误");
		}
		return result;
	}

	@Override
	public YhResult showMes(String token) {
		YhResult result = new YhResult();
		String json = jedisClusterDaoImpl.get(token);
		if (json != null && !json.equals("")) {
			YhUser user = JsonUtil.jsonToPojo(json, YhUser.class);
			user.setPassword(null);
			result.setData(user);
			result.setStatus(200);
			result.setMsg("OK");
		} else {
			result.setMsg("获取失败");
		}

		return result;
	}

	@Override
	public YhResult logout(String token, HttpServletRequest request, HttpServletResponse response) {
		YhResult result = new YhResult();
		if (jedisClusterDaoImpl.exists(token)) {
			jedisClusterDaoImpl.del(token);
			CookieUtils.deleteCookie(request, response, "TT_TOKEN");
		}
		result.setStatus(200);
		result.setMsg("OK");
		return result;
	}

}
