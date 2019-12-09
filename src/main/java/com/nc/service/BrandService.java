package com.nc.service;

import java.util.List;

import com.nc.pojo.Brand;
import com.nc.util.PageResult;

public interface BrandService {
     //查询所有    
	public List<Brand> findAll();
	/**
	 * 保存品牌的方法
	 */
	public void save(Brand brand);
	/**
	 * 删除多个
	 */
	public void delete(Long[] ids);
     
	/**
	 * 分页查询品牌的方法
	 */
	//public PageResult findByPage(Brand brand,int pageNum,int pageSize);
	public PageResult findByPage(int pageNum, int pageSize);
	
}
