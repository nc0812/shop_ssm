package com.nc.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nc.mapper.CategoryMapper;
import com.nc.pojo.Category;
import com.nc.pojo.CategoryExample;
import com.nc.service.CategoryService;
import com.nc.util.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    //支持分页的查询方法
//    public List<Category> list(Page page){
//        return categoryMapper.list(page);
//    };
    //获取总数的方法
//    public int total(){
//    	return categoryMapper.total();
//    }
    public List<Category> list(){
    	CategoryExample example = new CategoryExample();
    	example.setOrderByClause("id desc");
    	return categoryMapper.selectByExample(example);
    }
    //增加add方法的实现
    public void add(Category category){
    	categoryMapper.insert(category);
    }
    //delete删除的方法
    public void delete(int id){
    	categoryMapper.deleteByPrimaryKey(id);
    }
    //get编辑方法
    public Category get(int id){
    	return categoryMapper.selectByPrimaryKey(id);
    }
    //update修改方法
    public void update(Category category){
    	categoryMapper.updateByPrimaryKeySelective(category);
    }
	
    /**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Category> page= (Page<Category>) categoryMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}


	@Override
	public void deleteAll(Long[] ids) {
		for(Long id:ids){
			Integer b = id.intValue();
			categoryMapper.deleteByPrimaryKey(b);
		}
	}
	
 
}