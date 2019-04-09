package club.klovec.search.service;

import java.io.IOException;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

import club.klovec.pojo.YhIteams;

public interface YhIteamsService {
 	/**
 	 * 初始化solr
 	 * @throws SolrServerException
 	 * @throws IOException
 	 */
 	void init() throws SolrServerException, IOException ;


 	/**
 	 * 根据query实现商品搜索和分页
 	 * @param query
 	 * @param page
 	 * @param rows
 	 * @return
 	 */
 	Map<String,Object> selByQuery(String query,int page,int rows) throws SolrServerException, IOException ;

 	/**
 	 * 在solr中新增
 	 * @param iteams
 	 * @return
 	 */
 	int insSearch(Map<String,Object> map,String desc) throws SolrServerException, IOException;

}
