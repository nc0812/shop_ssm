package com.nc.service;

import java.util.List;
import java.util.Map;

import com.nc.pojo.Property;
import com.nc.util.PageResult;

public interface PropertyService {
	void add(Property c);
	void delete(int id);
	void update(Property c);
	Property get(int id);
	List list(int cid);
	
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Property> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Property findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param integer
	 */
	public void deleteAll(Long[] integer);

	/**
	 * 增加
	*/
	public void addd(Property property);


}
