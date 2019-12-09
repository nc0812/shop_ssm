package com.nc.service;
import com.nc.pojo.Category;
import com.nc.util.Page;
import com.nc.util.PageResult;

import java.util.List;
public interface CategoryService{
//    List<Category> list(Page page);//支持分页的查询方法
//    int total();//获取总数的方法
	List<Category> list();
    void add(Category category);//增加add方法
    void delete(int id);//删除方法;
    Category get(int id);//get编辑方法
    void update(Category category);//update修改方法《编辑后的修改》

    /**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);

	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteAll(Long [] ids);
	



}