package com.nc.service;

import java.util.List;

import com.nc.pojo.Admin;
import com.nc.pojo.Product;
import com.nc.util.PageResult;

public interface AdminService {
     
	//判断用户名
	public List<Admin> selectName(String name,String password);
	
	public PageResult findPage(int pageNum,int pageSize);

	public void delete(Long [] ids);
	 void add(Admin p);
}
