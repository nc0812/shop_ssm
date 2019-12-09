package com.nc.AdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nc.pojo.Brand;
import com.nc.service.impl.BrandServiceImpl;
import com.nc.util.PageResult;
import com.nc.util.Result;

@Controller
public class BrandController {
     
	@Autowired
	private BrandServiceImpl brandServiceImpl;
	
	@RequestMapping("/brandfindAll")
	@ResponseBody
	public List<Brand> findAll(){
		return brandServiceImpl.findAll();
	}
	
	@RequestMapping("/brandsave")
	@ResponseBody
	public Result save(@RequestBody Brand brand){
		try{
			brandServiceImpl.save(brand);
			
			return new Result(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false,"保存失败!");
		}
	}
	
	
	@RequestMapping("/branddelete")
	@ResponseBody
	public Result delete(Long[] ids){
		try{
			brandServiceImpl.delete(ids);
			
			return new Result(true,"删除成功!");
		}catch(Exception e){
			e.printStackTrace();
			return new Result(false,"删除失败!");
		}
	}
	
	
	@RequestMapping("/brandfindByPage")
	@ResponseBody
	public PageResult findByPage(int page,int rows){
		return brandServiceImpl.findByPage(page, rows);
	}
	
}
