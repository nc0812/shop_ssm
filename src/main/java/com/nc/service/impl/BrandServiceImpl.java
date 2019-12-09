package com.nc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nc.mapper.BrandMapper;
import com.nc.pojo.Brand;
import com.nc.service.BrandService;
import com.nc.util.PageResult;

@Service
public class BrandServiceImpl implements BrandService{
      
	@Autowired
	 private BrandMapper brandMapper;
	
	@Override
	public List<Brand> findAll() {
		List<Brand> list = brandMapper.selectByExample(null);
		return list;
	}

	@Override
	public void save(Brand brand) {	
		brandMapper.insert(brand);
	}

	@Override
	public void delete(Long[] ids) {
		
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
					}
		
	}

	@Override
	// 分页查询品牌的方法
	public PageResult findByPage(int pageNum, int pageSize) {
		// 使用分页插件:
		PageHelper.startPage(pageNum, pageSize);
		
		Page<Brand> page = (Page<Brand>) brandMapper.selectByExample(null);
		
		return new PageResult(page.getTotal(),page.getResult());
	}

}
