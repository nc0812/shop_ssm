package com.nc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nc.mapper.ProductImageMapper;
import com.nc.pojo.ProductImage;
import com.nc.pojo.ProductImageExample;
import com.nc.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
    ProductImageMapper productImageMapper;
	
	@Override
	public void add(ProductImage pi) {
		productImageMapper.insert(pi);
	}

	@Override
	public void delete(int id) {
		productImageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(ProductImage pi) {
		productImageMapper.updateByPrimaryKeySelective(pi);
	}

	@Override
	public ProductImage get(int id) {
		return productImageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list(int pid, String type) {
		ProductImageExample example =new ProductImageExample();
		example.createCriteria().andPidEqualTo(pid).andTypeEqualTo(type);
		example.setOrderByClause("id desc");
		 return productImageMapper.selectByExample(example);
	}
	
}
