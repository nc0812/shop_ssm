package com.nc.controller;

import java.util.Date;
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
import com.nc.pojo.Product;
import com.nc.service.CategoryService;
import com.nc.service.ProductService;
import com.nc.util.Page;
import com.nc.util.PageResult;
import com.nc.util.Result;

@Controller
@RequestMapping("")
public class ProductController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("admin_product_add")
	public String add(Model model, Product p){
		p.setCreateDate(new Date());
		productService.add(p);
		return "redirect:admin_product_list?cid="+p.getCid();
	}
	@RequestMapping("admin_product_delete")
	public String delete(int id){
		Product p = productService.get(id);
		productService.delete(id);
		return "redirect:admin_product_list?cid="+p.getCid();
	}
	@RequestMapping("admin_product_edit")
	public String edit(Model model, int id){
		Product p = productService.get(id);
		Category c = categoryService.get(id);
		p.setCategory(c);
		model.addAttribute("p", p);
		return "admin/editProduct";
	}
	@RequestMapping("admin_product_update")
	public String update(Product p){
		productService.update(p);
		return "redirect:admin_product_list?cid="+p.getCid();
	}
	@RequestMapping("admin_product_list")
	public String list(int cid, Model model, Page page){
		Category c = categoryService.get(cid);
		
		PageHelper.offsetPage(page.getStart(), page.getCount());;
		List<Product> ps = productService.list(cid);
		
		int total = (int) new PageInfo<>(ps).getTotal();
		page.setTotal(total);
		page.setParam("&cid="+c.getId());
		
		model.addAttribute("ps", ps);
		model.addAttribute("c", c);
		model.addAttribute("page", page);
		
		return "admin/listProduct";
	}
	
	@RequestMapping("/goodfindPage")
	@ResponseBody
	public PageResult  findPage(int page,int rows){			
		return productService.findPage(page, rows);
	}
 
	
	
	@RequestMapping("/goodadd")
	@ResponseBody
	public Result add(@RequestBody Product product){
		try {
			productService.add(product);
			return new Result(true, "增加成功");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/gooddeleteAll")
	@ResponseBody
	public Result deleteAll(Long [] ids){
	    try {
		productService.delete(ids);
	     return new Result(true,"删除成功");
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
	    	return new Result(false,"删除失败");
		}
	}
	
	/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/goodsearch")
	@ResponseBody
	public PageResult search(int page, int rows,String searchname){
       
		return productService.findPageByName(page, rows, searchname);
	}
	
}
