package com.nc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nc.pojo.Category;
import com.nc.service.CategoryService;
import com.nc.util.PageResult;
import com.nc.util.Result;

@Controller
public class ItemCatController {

	 @Autowired
     CategoryService categoryService;
	
	 
	 /**
		 * 返回分页列表
		 * @return
		 */
		@RequestMapping("/itemcatfindPage")
		@ResponseBody
		public PageResult  findPage(int page,int rows){			
			return categoryService.findPage(page, rows);
		}
		
		
		@RequestMapping("/itemcataddd")
		@ResponseBody
		public Result add(@RequestBody Category category){
			try {
				categoryService.add(category);
				return new Result(true, "增加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}
	    
	    
		@RequestMapping("/itemcatdeleteAll")
		public Result delete(Long [] ids){
			try {
				categoryService.deleteAll(ids);
				return new Result(true, "删除成功"); 
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "删除失败");
			}
		}
		
		
}
