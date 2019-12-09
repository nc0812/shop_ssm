package com.nc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nc.mapper.AdminMapper;
import com.nc.pojo.Admin;
import com.nc.pojo.AdminExample;
import com.nc.pojo.AdminExample.Criteria;
import com.nc.service.AdminService;
import com.nc.util.PageResult;

@Service
public class AdminServiceImpl implements AdminService{
     
	@Autowired
	 private AdminMapper adminMapper;
	
	@Override
	public List<Admin> selectName(String name, String password) {
		AdminExample example=new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andPasswordEqualTo(password);
		List<Admin> list = adminMapper.selectByExample(example);
		return list;
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Admin> page=(Page<Admin>) adminMapper.selectByExample(null);
		return new PageResult(page.getTotal(),page.getResult());
	}
    
	
	
	@Override
	public void delete(Long[] ids) {
	   
		for (Long long1 : ids) {
			Integer id=long1.intValue();
			adminMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public void add(Admin p) {
		
		adminMapper.insert(p);
	}

}
