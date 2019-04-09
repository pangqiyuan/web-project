package club.klovec.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.YhIteamsChild;
import club.klovec.dubbo.service.YhIteamsCatDubboService;
import club.klovec.dubbo.service.YhIteamsDescDubboService;
import club.klovec.dubbo.service.YhIteamsDubboService;
import club.klovec.pojo.YhIteams;
import club.klovec.pojo.YhIteamsCat;
import club.klovec.pojo.YhIteamsDesc;
import club.klovec.search.service.YhIteamsService;

@Service
public class YhIteamsServiceImpl implements YhIteamsService{
	@Reference
	private YhIteamsDubboService yhIteamsDubboServiceImpl;
	@Reference
	private YhIteamsCatDubboService yhIteamsCatDubboServiceImpl; 
	@Reference
	private YhIteamsDescDubboService yhIteamsDescDubboServiceImpl; 
	@Resource
	private CloudSolrClient solrClient; 
	@Override
	public void init() throws SolrServerException, IOException {
		//查询所有正常的商品
		List<YhIteams> listIteams = yhIteamsDubboServiceImpl.selAllByStatus((byte)1);
		for (YhIteams yhIteams : listIteams) {
			//商品对应的类目信息
			YhIteamsCat iteamsCat = yhIteamsCatDubboServiceImpl.selById(yhIteams.getCid());
			//商品对应的描述信息
			YhIteamsDesc iteamsDesc = yhIteamsDescDubboServiceImpl.selByIteamsID(yhIteams.getId());
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", yhIteams.getId());
			doc.addField("item_title", yhIteams.getTitle());
			doc.addField("item_sell_point", yhIteams.getSellPoint());
			doc.addField("item_price", yhIteams.getPrice());
			doc.addField("item_image", yhIteams.getImage());
			doc.addField("item_category_name", iteamsCat.getName());
			doc.addField("item_desc",iteamsDesc.getIteamsDesc());
			
			solrClient.add(doc);
			
		}
		solrClient.commit();
	}
	@Override
	public Map<String, Object> selByQuery(String query, int page, int rows) throws SolrServerException, IOException {
		SolrQuery params = new SolrQuery();
		//设置分页
		params.setStart(rows*(page-1));
		params.setRows(rows);
		//设置条件
		params.setQuery("item_keywords:"+query);
		
		//开启高亮
		params.setHighlight(true);
		params.addHighlightField("item_title");
		params.setHighlightSimplePre("<span style='color:red'>");
		params.setHighlightSimplePost("</span>");
		
		QueryResponse response = solrClient.query(params);
		
		List<YhIteamsChild> listChild = new ArrayList<>();
		//未高亮的内容
		SolrDocumentList results = response.getResults();
		//高亮的内容
		Map<String, Map<String, List<String>>> hh = response.getHighlighting();
		
		for (SolrDocument doc: results) {
			YhIteamsChild child = new YhIteamsChild();
			
			child.setId(Long.parseLong(doc.getFieldValue("id").toString()));
			List<String> list = hh.get(doc.getFieldValue("id")).get("item_title");
			if(list!=null && list.size()>0){
				child.setTitle(list.get(0));
			}else{
				child.setTitle(doc.getFieldValue("item_title").toString());
			}
			child.setSellPoint(doc.getFieldValue("item_sell_point").toString());
			Object image = doc.getFieldValue("item_image");
			child.setImages(image==null||image.equals("")?new String[1]:image.toString().split(","));
			child.setPrice((Long)doc.getFieldValue("item_price"));
			listChild.add(child);
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("itemList", listChild);
		map.put("totalPages", results.getNumFound()%rows ==0?results.getNumFound()/rows:results.getNumFound()/rows+1);
		
		
		return map;
	}
	@Override
	public int insSearch(Map<String,Object> map,String desc) throws SolrServerException, IOException {
		SolrInputDocument doc = new SolrInputDocument();
		Integer nn = (Integer)map.get("cid");
		doc.addField("id", map.get("id"));
		doc.addField("item_title", map.get("title"));
		doc.addField("item_sell_point", map.get("sellPoint"));
		doc.addField("item_price", map.get("price"));
		doc.addField("item_image", map.get("image"));
		doc.addField("item_category_name", yhIteamsCatDubboServiceImpl.selById(nn.longValue()).getName());
		doc.addField("item_desc",desc);
		UpdateResponse response = solrClient.add(doc);
		solrClient.commit();
		if(response.getStatus()==0){
			return 1;
		}
		return 0;
	}
	
}
