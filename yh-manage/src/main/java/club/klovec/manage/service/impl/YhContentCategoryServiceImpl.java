package club.klovec.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import club.klovec.common.pojo.EasyUITree;
import club.klovec.common.pojo.YhResult;
import club.klovec.common.util.IDUtil;
import club.klovec.dubbo.service.YhContentCategoryDubboService;
import club.klovec.manage.service.YhContentCategoryService;
import club.klovec.pojo.YhContentCategory;

@Service
public class YhContentCategoryServiceImpl implements YhContentCategoryService {
	@Reference
	private YhContentCategoryDubboService yhContentCategoryDubboServiceImpl; 
	@Override
	public List<EasyUITree> showContent(long id) {
		List<YhContentCategory> list = yhContentCategoryDubboServiceImpl.showTree(id);
		List<EasyUITree> uiTrees = new ArrayList<>();
		for (YhContentCategory cate : list) {
			EasyUITree tree = new EasyUITree();
			tree.setId(cate.getId());
			tree.setState(cate.getIsParent()?"closed":"open");
			tree.setText(cate.getName());
			uiTrees.add(tree);
		}
		return uiTrees;
	}
	@Override
	public YhResult insContentCategory(YhContentCategory yhContentCategory) {
		YhResult yhResult = new YhResult();
		//判断当前节点是否含有同名节点
		List<YhContentCategory> list = yhContentCategoryDubboServiceImpl.showTree(yhContentCategory.getParentId());
		for (YhContentCategory child : list) {
			if(child.getName().equals(yhContentCategory.getName())){
				return yhResult;
			}
		}
		
		Date date = new Date();
		yhContentCategory.setCreated(date);
		yhContentCategory.setUpdated(date);
		yhContentCategory.setIsParent(false);
		yhContentCategory.setStatus(1);
		yhContentCategory.setSortOrder(1);
		long id = IDUtil.genIteamsName();
		yhContentCategory.setId(id);
		int index = yhContentCategoryDubboServiceImpl.insYhContentCategory(yhContentCategory);
		if(index == 1){
			YhContentCategory category = new YhContentCategory();
			category.setId(yhContentCategory.getParentId());
			category.setIsParent(true);
			index += yhContentCategoryDubboServiceImpl.updIsParentByID(category);
		}
		if(index == 2){
			Map<String ,Long> map = new HashMap<>(); 
			map.put("id", id);
			yhResult.setStatus(200);
			yhResult.setData(map);
		}
		return yhResult;
		
	}
	@Override
	public YhResult updateCategory(YhContentCategory yhContentCategory) {
		YhResult result = new YhResult();
		
 		YhContentCategory pCategory = yhContentCategoryDubboServiceImpl.selByID(yhContentCategory.getId());
		List<YhContentCategory> list = yhContentCategoryDubboServiceImpl.showTree(pCategory.getId());
		for (YhContentCategory child : list) {
			if(child.getName().equals(yhContentCategory.getName())){
				return result;
			}
		}
		
		int index = yhContentCategoryDubboServiceImpl.updIsParentByID(yhContentCategory);
		if(index == 1){
			result.setStatus(200);
		}
		return result;
	}
	@Override
	public YhResult deleteCategory(YhContentCategory yhContentCategory) {
		YhResult result = new YhResult();
		
		yhContentCategory.setStatus(2);
		int index = yhContentCategoryDubboServiceImpl.updIsParentByID(yhContentCategory);
		
		if(index>0){
			YhContentCategory category = yhContentCategoryDubboServiceImpl.selByID(yhContentCategory.getId());
			List<YhContentCategory> list = yhContentCategoryDubboServiceImpl.showTree(category.getParentId());
			if(list.size() == 0 || list == null){
				YhContentCategory parent = new YhContentCategory();
				parent.setIsParent(false);
				parent.setId(category.getParentId());
				int i = yhContentCategoryDubboServiceImpl.updIsParentByID(parent);	
				if(i>0){
					result.setStatus(200);
				}
			}else{
				result.setStatus(200);
			}
		}
		
		return result;
	}
	
}
