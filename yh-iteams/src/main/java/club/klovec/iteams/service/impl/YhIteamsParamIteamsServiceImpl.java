package club.klovec.iteams.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.util.JsonUtil;
import club.klovec.dubbo.service.YhIteamsParamIteamsDubboService;
import club.klovec.iteams.pojo.ParamIteams;
import club.klovec.iteams.service.YhIteamsParamIteamsService;
import club.klovec.pojo.YhIteamsParamIteams;

@Service
public class YhIteamsParamIteamsServiceImpl implements YhIteamsParamIteamsService {
	@Reference
	private YhIteamsParamIteamsDubboService yhIteamsParamIteamsDubboServiceImpl;

	@Override
	public String selByIteamsID(long id) {
		YhIteamsParamIteams iteams = yhIteamsParamIteamsDubboServiceImpl.selByIteamsId(id);
		List<ParamIteams> list = JsonUtil.jsonToList(iteams.getParamData(), ParamIteams.class);
		
		StringBuffer sf = new StringBuffer();
		for (ParamIteams param : list) {
			sf.append("<table width='500' style='color:gray;'>");
			for (int i = 0; i < param.getParams().size(); i++) {
				if (i == 0) {
					sf.append("<tr>");
					sf.append("<td align='right' width='30%'>" + param.getGroup() + "</td>");
					sf.append("<td align='right' width='30%'>" + param.getParams().get(i).getK() + "</td>");
					sf.append("<td>" + param.getParams().get(i).getV() + "</td>");
					sf.append("<tr/>");
				} else {
					sf.append("<tr>");
					sf.append("<td> </td>");
					sf.append("<td align='right'>" + param.getParams().get(i).getK() + "</td>");
					sf.append("<td>" + param.getParams().get(i).getV() + "</td>");
					sf.append("</tr>");
				}
			}
			sf.append("</table>");
			sf.append("<hr style='color:gray;'/>");
		}

		return sf.toString();
	}

}
