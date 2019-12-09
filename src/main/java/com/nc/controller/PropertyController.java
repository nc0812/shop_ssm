package com.nc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nc.pojo.Category;
import com.nc.pojo.Property;
import com.nc.service.CategoryService;
import com.nc.service.PropertyService;
import com.nc.util.Page;
import com.nc.util.PageResult;
import com.nc.util.Result;

@Controller
@RequestMapping("")
public class PropertyController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	PropertyService propertyService;
	
	@RequestMapping("admin_property_add")
	public String add(Model model, Property p){
		propertyService.add(p);
		return "redirect:admin_property_list?cid="+p.getCid();
	}
	@RequestMapping("admin_property_delete")
	public String delete(int id){
		Property p = propertyService.get(id);
		propertyService.delete(id);
		return "redirect:admin_property_list?cid="+p.getCid();
	}
	@RequestMapping("admin_property_edit")
	public String edit(Model model, int id){
		Property p = propertyService.get(id);
		Category c = categoryService.get(p.getCid());
		p.setCategory(c);
		model.addAttribute("p", p);
		return "admin/editProperty";
	}
	@RequestMapping("admin_property_update")
	public String update(Property p){
		propertyService.update(p);
		return "redirect:admin_property_list?cid="+p.getCid();
	}
	@RequestMapping("admin_property_list")
	public String list(int cid, Model model, Page page){
		Category c = categoryService.get(cid);
		
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Property> ps = propertyService.list(cid);
		
		int total = (int) new PageInfo<>(ps).getTotal();
		page.setTotal(total);
		page.setParam("&cid=" + c.getId());
		
		model.addAttribute("ps", ps);
		model.addAttribute("c", c);
		model.addAttribute("page", page);
		
		return "admin/listProperty";
	}
	
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	@RequestMapping("/propertyfindPage")
	@ResponseBody
	public PageResult  findPage(int page,int rows){			
		return propertyService.findPage(page, rows);
	}
	
	/**
	 * 批量删除
	 */
	@RequestMapping("/propertydeleteAll")
	@ResponseBody	
	public Result deleteAll(Long [] ids){
		try {
			propertyService.deleteAll(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	
	/**
	 * 增加
	 * @param specification
	 * @return
	 */
	@RequestMapping("/propertyaddd")
	@ResponseBody	
	public Result addd(@RequestBody Property property){
		try {
			propertyService.addd(property);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	
}
