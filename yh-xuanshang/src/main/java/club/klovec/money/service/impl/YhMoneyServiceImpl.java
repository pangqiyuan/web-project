package club.klovec.money.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.YhResult;
import club.klovec.common.util.CookieUtils;
import club.klovec.common.util.JsonUtil;
import club.klovec.dubbo.service.YhXuanShangDubboService;
import club.klovec.money.service.YhMoneyService;
import club.klovec.pojo.YhUser;
import club.klovec.pojo.YhXuanshang;
import club.klovec.redis.dao.JedisClusterDao;

@Service
public class YhMoneyServiceImpl implements YhMoneyService {
	@Reference
	private YhXuanShangDubboService yhXuanShangDubboServiceImpl;
	@Resource
	private JedisClusterDao jedisClusterDaoImpl;

	@Override
	public YhResult insXuanshang(YhXuanshang xs, HttpServletRequest request) {
		String cookieValue = CookieUtils.getCookieValue(request, "TT_TOKEN");
		String string = jedisClusterDaoImpl.get(cookieValue);
		YhUser user = JsonUtil.jsonToPojo(string, YhUser.class);

		Date date = new Date();
		xs.setCid(user.getId());
		xs.setCreatDate(date);
		xs.setUpdateDate(date);
		xs.setStatus(1);

		int index = yhXuanShangDubboServiceImpl.insXuanShang(xs);
		YhResult result = new YhResult();
		if(index==1){
			result.setStatus(200);
		}
		return result;
	}

	@Override
	public YhResult showMes(HttpServletRequest request) {
		/*String cookieValue = CookieUtils.getCookieValue(request, "TT_TOKEN");
		String string = jedisClusterDaoImpl.get(cookieValue);
		YhResult yhResult = JsonUtil.jsonToPojo(string, YhResult.class);
		YhUser user = JsonUtil.jsonToPojo(yhResult.getData().toString(), YhUser.class);*/
		List<YhXuanshang> list = yhXuanShangDubboServiceImpl.showXuanshang((long)-1);
		YhResult result = new YhResult();
		System.out.println(list.size());
		if(list.size()>0 && list!=null){
			result.setStatus(200);
			result.setMsg(list.size()+"");
			result.setData(list);
		}
		return result;
	}

}
