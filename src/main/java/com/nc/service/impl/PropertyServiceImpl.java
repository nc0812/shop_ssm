package com.nc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nc.mapper.PropertyMapper;
import com.nc.pojo.Property;
import com.nc.pojo.PropertyExample;
import com.nc.service.PropertyService;
import com.nc.util.PageResult;

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyMapper propertyMapper;
	
	@Override
	public void add(Property p) {
		propertyMapper.insert(p);
	}

	@Override
	public void delete(int id) {
		propertyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Property p) {
		propertyMapper.updateByPrimaryKeySelective(p);
	}

	@Override
	public Property get(int id) {
		return propertyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list(int cid) {
		PropertyExample example = new PropertyExample();
		example.createCriteria().andCidEqualTo(cid);
		example.setOrderByClause("id desc");
		return propertyMapper.selectByExample(example);
	}

	/***
	  * 返回所有数据       
	 */
	@Override
	public List<Property> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Property> page=   (Page<Property>) propertyMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	
	}

	@Override
	public Property findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll(Long[] ids) {
		for(Long id:ids){
			Integer b = id.intValue();
			propertyMapper.deleteByPrimaryKey(b);
		}
	}

	@Override
	public void addd(Property property) {
		
		propertyMapper.insert(property);
	}
	
}
